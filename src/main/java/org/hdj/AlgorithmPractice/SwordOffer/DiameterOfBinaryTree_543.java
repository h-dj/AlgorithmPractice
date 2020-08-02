package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/8/2 上午11:14
 * @description: <pre>
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * </pre>
 */
public class DiameterOfBinaryTree_543 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int max = 0;
    static TreeNode rootPointer = null;

    /**
     * 递归形式
     *
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (rootPointer == null) {
            rootPointer = root;
        }
        int lLen = 0;
        int rLen = 0;
        //左子树的长度
        if (root.left != null) {
            lLen = diameterOfBinaryTree(root.left) + 1;
        }
        //右子树的长度
        if (root.right != null) {
            rLen = diameterOfBinaryTree(root.right) + 1;
        }
        //当前节点左右子树长度和
        int currenLen = rLen + lLen;
        //与max比较，取最大值，max是其子节点左右子树长度的最大值
        max = Math.max(currenLen, max);
        //如果当前节点是根节点
        //说明已统计根节点左右子树长度
        //返回左右子树长度和
        if (root == rootPointer) {
            return max;
        }
        //判断左右子树长度,用于代表该节点长度
        if (rLen == lLen) {
            return rLen;
        }
        return Math.max(rLen, lLen);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node8 = new TreeNode(8);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node20 = new TreeNode(20);
        TreeNode node22 = new TreeNode(22);
        TreeNode node40 = new TreeNode(40);

        root.left = node2;
        node2.left = node4;
        node2.right = node5;

        node4.left = node8;
        node5.left = node10;
        node5.right = node11;
        node10.left = node20;
        node20.left = node40;
        node11.right = node22;

        int i = diameterOfBinaryTree(root);
        System.out.println(i);

    }
}
