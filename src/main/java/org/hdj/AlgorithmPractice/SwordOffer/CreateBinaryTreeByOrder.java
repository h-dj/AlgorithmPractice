package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 10/24/19 2:12 PM
 * @description:　重建二叉树 <br/>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class CreateBinaryTreeByOrder {

    /**
     * 树节点
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 通过前序遍历和中序遍历，　创建二叉树
     * <p>
     * 规则: 前序遍历：　第一个一定是根节点；　中序遍历：以根节点分割，左边的为二叉树的左子树，右边为二叉树的右子树
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return getRootNode(pre, in, 0, 0, in.length);
    }

    /**
     * 获取根节点
     *
     * @param pre
     * @param in
     * @param preIndex
     * @param inIndex
     * @param count
     * @return
     */
    private TreeNode getRootNode(int[] pre, int[] in, int preIndex, int inIndex, int count) {
        TreeNode root = null;
        if (count > 0) {
            //获取前序遍历的序列的根结点
            int r = pre[preIndex];
            //记录根结点在中序遍历中的位置
            int i = 0;
            for (; i < count; i++) {
                if (r == in[i + inIndex]) {
                    break;
                }
            }
            //创建根结点
            root = new TreeNode(r);
            //创建左子树的根节点
            root.left = getRootNode(pre, in, preIndex + 1, inIndex, i);
            //创建右子树的根节点
            root.right = getRootNode(pre, in, preIndex + i + 1, inIndex + i + 1, count - i - 1);
        }
        return root;
    }


    /**
     * 前序遍历(中左右)
     *
     * @param treeNode
     */
    public static void printPreOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " ");
        printPreOrder(treeNode.left);
        printPreOrder(treeNode.right);
    }

    /**
     * 中序遍历(左中右)
     *
     * @param treeNode
     */
    public static void printInOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printInOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        printInOrder(treeNode.right);
    }

    public static void main(String[] args) {
        CreateBinaryTreeByOrder c = new CreateBinaryTreeByOrder();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = c.reConstructBinaryTree(pre, in);

        System.out.println(treeNode.val);


        printPreOrder(treeNode);
        System.out.println();
        printInOrder(treeNode);
    }


}
