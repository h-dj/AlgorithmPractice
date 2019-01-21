package org.hdj.AlgorithmPractice.Tree.LinkTree;

import org.hdj.AlgorithmPractice.Queue.LinkQueue;
import org.hdj.AlgorithmPractice.Stack.LinkStack.LinkStack;

/**
 * 链式二叉树
 */
public class LinkBiTree<T> {

    //根结点
    public BiTreeNode<T> root;

    public LinkBiTree() {
        this.root = new BiTreeNode<>();
    }


    public LinkBiTree(BiTreeNode<T> root) {
        this.root = root;
    }

    /**
     * 由标明的空子树建立二叉树
     *
     * @param preOrder
     */
    private static int preIndex = 0;

    public LinkBiTree(String preOrder) {
        //获取前序遍历中的根结点
        char c = preOrder.charAt(preIndex++);
        //如果字符不为#
        if ('#' != c) {
            //创建根结点
            root = new BiTreeNode(c);
            //创建左子树
            root.LChild = new LinkBiTree(preOrder).root;
            //创建右子树
            root.RChild = new LinkBiTree(preOrder).root;
        } else {
            root = null;
        }
    }

    /**
     * 二叉树的建立
     *
     * @param preOrder 前序遍历的序列
     * @param inOrder  中序遍历的序列
     * @param preIndex 前序遍历开始位置
     * @param inIndex  中序遍历开始位置
     * @param count    结点数
     */
    public LinkBiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
        if (count > 0) {
            //获取前序遍历的序列的根结点
            char r = preOrder.charAt(preIndex);
            //记录根结点在中序遍历中的位置
            int i = 0;
            for (; i < count; i++) {
                if (r == inOrder.charAt(i + inIndex)) {
                    break;
                }
            }
            root = new BiTreeNode(r);
            root.LChild = new LinkBiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root;
            root.RChild = new LinkBiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1).root;

        }
    }


    /**
     * 递归的前序遍历
     * <p>
     * 1. 从根结点出发
     * 2. 先遍历完左子树
     * 3. 再遍历右子树
     * <p>
     * （注意：顺序: 中左右）
     *
     * @param treeNode
     */
    public void preOrderTraverse(BiTreeNode treeNode) {
        if (treeNode == null) return;

        //结点数据
        System.out.println(treeNode.data.toString());

        //先遍历左子树
        preOrderTraverse(treeNode.LChild);

        //然后遍历右子树
        preOrderTraverse(treeNode.RChild);
    }

    /**
     * 非递归的前序遍历
     */
    public void preOrderTraverse() {
        //获取根结点
        BiTreeNode<T> node = root;
        if (node == null) return;

        //构造一个栈，由于存储右子树结点
        LinkStack<BiTreeNode> stack = new LinkStack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            //弹出栈顶结点
            node = stack.pop();
            System.out.print(node.data);
            while (node != null) {
                //如果左结点不为空，则访问
                if (node.LChild != null)
                    System.out.print(node.LChild.data);

                //如果右结点不为空，则先压入栈中
                if (node.RChild != null)
                    stack.push(node.RChild);

                //继续遍历左结点
                node = node.LChild;
            }
        }

    }

    /**
     * 中序遍历（递归方式）
     * <p>
     * 1. 从左子树出发开始遍历
     * 2. 遍历到根结点
     * 3. 又从根结点出发，遍历右子树
     * <p>
     * （注意：顺序: 左中右）
     *
     * @param treeNode
     */
    public void inOrderTraverse(BiTreeNode treeNode) {
        if (treeNode == null) return;

        //遍历左子树
        inOrderTraverse(treeNode.LChild);

        //结点数据
        System.out.println(treeNode.data.toString());

        //遍历右子树
        inOrderTraverse(treeNode.RChild);
    }

    /**
     * 中序遍历（非递归）
     */
    public void inOrderTraverse() {
        BiTreeNode<T> node = this.root;
        if (node != null) {
            LinkStack<BiTreeNode> stack = new LinkStack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                while (stack.peek() != null)
                    stack.push(stack.peek().LChild);  //把左结点入栈，直到最左下的结点

                //弹出空结点
                stack.pop();
                if (!stack.isEmpty()) {
                    node = stack.pop();
                    //打印结点
                    System.out.print(node.data.toString());
                    //把该结点的右子结点入栈
                    stack.push(node.RChild);
                }
            }
        }
    }


    /**
     * 后序遍历
     * <p>
     * 1. 以从左到右的方式
     * 2. 先遍历左子树
     * 3. 然后遍历右子树
     * 4. 最后遍历右子树
     * <p>
     * 顺序： 左右中
     */
    public void postOrderTraverse(BiTreeNode treeNode) {
        if (treeNode == null) return;

        postOrderTraverse(treeNode.LChild);
        postOrderTraverse(treeNode.RChild);

        System.out.println(treeNode.data.toString());
    }

    /**
     * 后序遍历（非递归）
     */
    public void postOrderTraverse() {
        //获取根结点
        BiTreeNode node = this.root;
        if (node != null) {
            LinkStack<BiTreeNode> stack = new LinkStack<>();
            //将根结点入栈
            stack.push(node);
            //设置结点访问标识
            boolean flag;
            //设置指针，指向访问过的结点
            BiTreeNode p = null;
            while (!stack.isEmpty()) {
                //将结点的左子结点入栈
                while (stack.peek() != null)
                    stack.push(stack.peek().LChild);
                //弹出空结点
                stack.pop();
                while (!stack.isEmpty()) {
                    //查看栈顶元素
                    node = stack.peek();

                    //如果该结点的右子结点为空，或已访问过，则该结点可以出栈访问
                    if (node.RChild == null || node.RChild == p) {
                        //访问结点
                        System.out.print(node.data.toString());
                        //出栈
                        stack.pop();
                        //已访问指针指向该结点
                        p = node;
                        //标识为已访问
                        flag = true;
                    } else {
                        //否则，将该结点的右子结点入栈，
                        stack.push(node.RChild);
                        // 标识该结点还没访问
                        flag = false;
                    }

                    if (!flag) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 层次遍历
     */
    public void levelTraverse() {
        BiTreeNode<T> node = this.root;
        if (node != null) {
            //初始化队列
            LinkQueue<BiTreeNode> queue = new LinkQueue<>();
            //根结点入队列
            queue.offer(node);

            while (!queue.isEmpty()) {
                //出队列
                node = queue.poll();
                //访问该结点
                System.out.println(node.data.toString());
                //该结点的左子结点入队列
                if (node.LChild != null) {
                    queue.offer(node.LChild);
                }
                //该结点的右子结点入队列
                if (node.RChild != null) {
                    queue.offer(node.RChild);
                }
            }
        }
    }

    public BiTreeNode searchBiTreeNode(Object x) {
        return searchBiTreeNode(this.root, x);
    }

    /**
     * 查找值为X 的 结点
     *
     * @param node
     * @param x
     * @return
     */
    public BiTreeNode searchBiTreeNode(BiTreeNode node, Object x) {
        if (node != null) {
            //如果结点node的值与x相同，则返回node
            if (node.data.equals(x)) {
                return node;
            } else {
                //查找结结点node 的左子树结点
                BiTreeNode result = searchBiTreeNode(node.LChild, x);
                //如果左子树结点没找到，则从右子树结点找
                if (result == null) {
                    result = searchBiTreeNode(node.RChild, x);
                }
                return result;
            }
        }
        //如果找不到，则返回空
        return null;
    }

    public int countTreeNode() {
        return countTreeNode(this.root);
    }

    /**
     * 统计二叉树的结点数
     *
     * @return
     */
    public int countTreeNode(BiTreeNode<T> node) {
        int count = 0;
        if (node != null) {
            //根结点加一
            ++count;
            //统计二叉树的左子树结点
            count += countTreeNode(node.LChild);
            //统计二叉树的右子树结点
            count += countTreeNode(node.RChild);
        }
        return count;
    }

    /**
     * 非递归方式，统计结点
     *
     * @return
     */
    public int countTreeNode2() {
        int count = 0;
        //获取根结点
        BiTreeNode<T> node = this.root;
        if (node != null) {
            //使用队列存放树的结点，方便统计
            LinkQueue<BiTreeNode> queue = new LinkQueue<>();
            //把根结点放入队列
            queue.offer(node);
            while (!queue.isEmpty()) {
                //出栈
                node = queue.poll();
                //计数
                ++count;
                //把该左结点放入队列
                if (node.LChild != null) {
                    queue.offer(node.LChild);
                }
                //把该右结点放入队列
                if (node.RChild != null) {
                    queue.offer(node.RChild);
                }
            }
        }
        return count;
    }

    /**
     * 统计二叉树的叶子数
     *
     * @return
     */
    public int countTreeLeaf() {
        int count = 0;
        //获取根结点
        BiTreeNode<T> node = this.root;
        if (node != null) {
            //使用队列存放树的结点，方便统计
            LinkQueue<BiTreeNode> queue = new LinkQueue<>();
            //把根结点放入队列
            queue.offer(node);
            while (!queue.isEmpty()) {
                //出栈
                node = queue.poll();

                //把该左结点放入队列
                if (node.LChild != null) {
                    queue.offer(node.LChild);
                }
                //把该右结点放入队列
                if (node.RChild != null) {
                    queue.offer(node.RChild);
                }

                /**
                 * 如果该结点没有左右子树，则为叶结点，计数加一
                 */
                if (node.LChild == null && node.RChild == null) {
                    ++count;
                }
            }
        }
        return count;
    }

    /**
     * 获取树的深度
     * <p>
     * 1. 获取左子树的深度
     * 2. 获取右子树的深度
     * 3. 取左右子树深度的最大值+1
     *
     * @return
     */
    public int getTreeDepth(BiTreeNode<T> node) {
        if (node != null) {
            int lDepth = getTreeDepth(node.LChild);
            int rDepth = getTreeDepth(node.RChild);
            return 1 + (lDepth > rDepth ? lDepth : rDepth);
        }
        return 0;
    }

    /**
     * 获取二叉树深度（非递归）
     * <p>
     * 采用层次遍历
     *
     * @return
     */
    public int getTreeDepth2() {
        int count = 0; //计数
        //获取根结点
        BiTreeNode<T> node = this.root;
        if (node != null) {
            //采用队列保存每一层的结点数
            LinkQueue<BiTreeNode> queue = new LinkQueue<>();
            //放入第一层结点
            queue.offer(node);
            while (!queue.isEmpty()) {
                //获取每层结点数
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    //出队列
                    node = queue.poll();
                    //把下一层结点加入队列
                    if (node.LChild != null) {
                        queue.offer(node.LChild);
                    }
                    if (node.RChild != null) {
                        queue.offer(node.RChild);
                    }
                }
                //计数
                ++count;
            }
        }
        return count;

    }


    /**
     * 判断二叉树是否相等
     * <p>
     * <p>
     * 操作步骤
     * <p>
     * 1. 如果二叉树都为空，则两棵二叉树相等，返回true
     * 2. 先根结点的值相等，则判断左子树
     * 3. 判断完左子树，再判断右子树
     * 4. 左右子树都相同，则两棵二叉树相等
     *
     * @return
     */
    public boolean isEqual(BiTreeNode<T> node1, BiTreeNode<T> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {

            //如果结点的值相等，
            if (node1.data.equals(node2.data)) {
                //则判断左子树
                if (isEqual(node1.LChild, node2.LChild)) {
                    //左子树相等，则判断右子树
                    if (isEqual(node1.RChild, node2.RChild)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
