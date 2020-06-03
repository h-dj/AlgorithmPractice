package org.hdj.AlgorithmPractice.LeetCode.algorith;

import javax.swing.tree.TreeNode;

/**
 * @author hdj
 * @version 1.0
 * @date 03/06/2020 22:07
 * @description: 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * <pre>
 *     示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * </pre>
 */
public class BrinaryTree_543 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);


        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;

        node4.left = node6;

        node3.left = node8;
        node3.right = node9;
        System.out.println(diameterOfBinaryTree(root));

    }

    static int max = 0;
    static TreeNode rootPointer = null;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (rootPointer == null) {
            rootPointer = root;
        }
        int lLen = 0;
        int rLen = 0;
        //得出左子树高度
        if (root.left != null) {
            lLen = diameterOfBinaryTree(root.left) + 1;
        }
        //得出右子树高度
        if (root.right != null) {
            rLen = diameterOfBinaryTree(root.right) + 1;
        }
        //左右子树相加，是否是最大
        int currenLen = rLen + lLen;
        max = Math.max(currenLen, max);
        if (root == rootPointer) {
            return max;
        }
        //否则，回到上一个节点
        if (rLen == lLen) {
            return rLen;
        }
        return Math.max(rLen, lLen);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

