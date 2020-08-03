package org.hdj.AlgorithmPractice.SwordOffer;

import java.util.LinkedList;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/8/3 下午12:43
 * @description: <pre>
 *     输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * </pre>
 *
 *
 */
public class DeptTree_55 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        int depth = 0;
        while (!stack.isEmpty()) {
            //获取每层的节点数
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();
                if (pop.left != null) {
                    stack.offerLast(pop.left);
                }
                if (pop.right != null) {
                    stack.offerLast(pop.right);
                }
            }
            ++depth;
        }
        return depth;
    }

    /**
     * 数组生成二叉树
     *
     * @param tree
     * @param index
     * @return
     */
    public static TreeNode genTree(int[] tree, int index) {
        if (index >= tree.length) {
            return null;
        }
        int value = tree[index];
        if (value == -1) {
            return null;
        }

        TreeNode root = new TreeNode(value);
        int leftIndex = 2 * index + 1;
        if (leftIndex < tree.length) {
            int left = tree[leftIndex];
            if (left != -1) {
                root.left = genTree(tree, leftIndex);
            }
        }

        int rightIndex = 2 * index + 2;
        if (rightIndex < tree.length) {
            int right = tree[rightIndex];
            if (right != -1) {
                root.right = genTree(tree, rightIndex);
            }
        }
        return root;
    }

    public static void display(TreeNode temp) {
        if (temp == null) {
            return;
        }
        System.out.println(temp.val);
        display(temp.left);
        display(temp.right);
    }

    public static void main(String[] args) {
        int[] tree = {1, 2, 3, 4, -1, -1, 5};
        TreeNode treeNode = genTree(tree, 0);

        int i = maxDepth(treeNode);
        System.out.println(i);

        i = maxDepth2(treeNode);
        System.out.println(i);

    }
}
