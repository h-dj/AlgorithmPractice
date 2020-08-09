package org.hdj.AlgorithmPractice.SwordOffer;

import java.util.LinkedList;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/7/30 下午12:59
 * @description:　二叉树镜像 <pre>
 *     请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 * </pre>
 */
public class BinaryTreeMirror_27 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = root.right != null ? mirrorTree(root.right) : null;
        newRoot.right = root.left != null ? mirrorTree(root.left) : null;
        return newRoot;
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public static TreeNode mirrorTree2(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offerLast(root);
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            if (pop == null) {
                continue;
            }
            if (pop.right != null) {
                treeNodes.offerLast(pop.right);
            }
            if (pop.left != null) {
                treeNodes.offerLast(pop.left);
            }
            TreeNode left = pop.left;
            pop.left = pop.right;
            pop.right = left;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = Utils.genTree("4796231", "9764321", 0, 0, 7);
        Utils.display(root);
        System.out.println();
        TreeNode treeNode = mirrorTree(root);
        Utils.display(treeNode);
        System.out.println();
        treeNode = mirrorTree2(root);
        Utils.display(treeNode);
    }
}
