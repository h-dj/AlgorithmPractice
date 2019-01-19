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
        this(null);
    }

    public LinkBiTree(BiTreeNode<T> root) {
        this.root = root;
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
            //访问该结点
            System.out.println(node.data.toString());
            while (node != null) {
                //如果左结点不为空，则访问
                if (node.LChild != null)
                    System.out.println(node.LChild.data);

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
                    System.out.println(node.data.toString());
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
                        System.out.println(node.data.toString());
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
}
