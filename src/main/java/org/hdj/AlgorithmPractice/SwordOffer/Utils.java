package org.hdj.AlgorithmPractice.SwordOffer;

import org.hdj.AlgorithmPractice.DataStructure.Tree.LinkTree.BiTreeNode;

import java.util.LinkedList;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/8/9 下午4:32
 * @description:
 */
public class Utils {

    public static void inOrderTraverse(TreeNode treeNode) {
        if (treeNode == null) return;

        //遍历左子树
        inOrderTraverse(treeNode.left);

        //结点数据
        System.out.println(treeNode.val);

        //遍历右子树
        inOrderTraverse(treeNode.right);
    }

    public void preOrderTraverse(TreeNode treeNode) {
        if (treeNode == null) return;

        //结点数据
        System.out.println(treeNode.val);

        //先遍历左子树
        preOrderTraverse(treeNode.left);

        //然后遍历右子树
        preOrderTraverse(treeNode.right);
    }


    public static void display(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            System.out.print(pop.val + " ");
            if (pop.left != null) {
                queue.offerLast(pop.left);
            }
            if (pop.right != null) {
                queue.offerLast(pop.right);
            }
        }
        System.out.println();
    }

    /**
     * 生成二叉树
     *
     * @return
     */
    public static TreeNode genTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
        if (count <= 0) {
            return null;
        }
        //获取前序遍历的序列的根结点
        char r = preOrder.charAt(preIndex);
        //记录根结点在中序遍历中的位置
        int i = 0;
        for (; i < count; i++) {
            if (r == inOrder.charAt(i + inIndex)) {
                break;
            }
        }
        //创建根结点
        TreeNode treeNode = new TreeNode(Integer.parseInt(String.valueOf(r)));
        treeNode.left = genTree(preOrder, inOrder, preIndex + 1, inIndex, i);
        treeNode.right = genTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1);
        return treeNode;
    }


    public static ListNode genNode(int start, int length) {
        ListNode h = new ListNode(start);
        if (start == length) {
            return h;
        }
        h.next = genNode(start + 1, length);
        return h;
    }

    public static void display(ListNode head) {
        ListNode next = head.next;
        while (next != null) {
            System.out.print(next.val + " ");
            next = next.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}