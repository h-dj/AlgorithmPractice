package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 10/24/19 3:29 PM
 * @description: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextNodeInOrder {

    class TreeLinkNode {
        String value;
        TreeLinkNode next;
        TreeLinkNode left;
        TreeLinkNode right;

        public TreeLinkNode(String value) {
            this.value = value;
        }
    }

    /**
     * 获取下一个节点
     * <p>
     * 中序遍历的顺序为 左中右
     * 1. 如果节点有右子树，则下一个节点就是右子树中最左子节点
     * 2. 如果节点没有右子树，并且是其父节点的左节点，则父节点为下一个节点
     * 3. 如果节点没有右子树, 还是其父节点的右节点，那么随着父指针遍历，需要找到一个父辈节点并且带有左节点的节点，那么这个节点就是下一个节点
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        //1.有右子树
        if (pNode.right != null) {
            TreeLinkNode next = pNode.right;
            while (next.left != null) {
                next = next.left;
            }
            return next;
        }


        TreeLinkNode p = pNode.next;
        if (p != null) {

            //2. 没有右子树，为左节点
            if (pNode == p.left) {
                return p;
            }

            //3.　没有右子树，为右节点
            TreeLinkNode c = pNode;
            if (p.right == c) {
                while (p != null && c == p.right) {
                    c = p;
                    p = p.next;
                }
                return p;
            }
        }
        return null;
    }

    /**
     * 中序遍历(左中右)
     *
     * @param treeNode
     */
    public static void printInOrder(TreeLinkNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printInOrder(treeNode.left);
        System.out.print(treeNode.value + " ");
        printInOrder(treeNode.right);
    }


    public static void main(String[] args) {
        GetNextNodeInOrder getNextNodeInOrder = new GetNextNodeInOrder();

        TreeLinkNode a = getNextNodeInOrder.new TreeLinkNode("a");
        TreeLinkNode b = getNextNodeInOrder.new TreeLinkNode("b");
        TreeLinkNode c = getNextNodeInOrder.new TreeLinkNode("c");
        TreeLinkNode d = getNextNodeInOrder.new TreeLinkNode("d");
        TreeLinkNode e = getNextNodeInOrder.new TreeLinkNode("e");
        TreeLinkNode f = getNextNodeInOrder.new TreeLinkNode("f");
        TreeLinkNode g = getNextNodeInOrder.new TreeLinkNode("g");
        TreeLinkNode h = getNextNodeInOrder.new TreeLinkNode("h");
        TreeLinkNode i = getNextNodeInOrder.new TreeLinkNode("i");


        a.left = b;
        a.right = c;

        b.next = a;
        b.left = d;
        b.right = e;

        d.next = b;

        e.next = b;
        e.right = i;
        e.left = h;
        i.next = e;
        h.next = e;

        c.next = a;
        c.left = f;
        c.right = g;

        f.next = c;
        g.next = c;

        //打印中序序列
        printInOrder(a);

        System.out.println();

        //获取某个节点在中序序列中的下一个节点
        TreeLinkNode treeLinkNode = getNextNodeInOrder.GetNext(b);
        System.out.println(treeLinkNode.value);


        treeLinkNode = getNextNodeInOrder.GetNext(a);
        System.out.println(treeLinkNode.value);

        treeLinkNode = getNextNodeInOrder.GetNext(i);
        System.out.println(treeLinkNode.value);

        //因为节点g是中序序列中的最后一个，所以g的下一个节点为null
        treeLinkNode = getNextNodeInOrder.GetNext(g);
        //System.out.println(treeLinkNode.value);
    }
}
