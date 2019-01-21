package org.hdj.AlgorithmPractice.DSJD2E.ch5;

import org.hdj.AlgorithmPractice.Tree.LinkTree.BiTreeNode;
import org.hdj.AlgorithmPractice.Tree.LinkTree.LinkBiTree;

/**
 * 二叉树的建立
 * 由完全二叉树的顺序存储构建
 */
public class Example5_7 {

    /**
     * @param sqBiTree  完全二叉树的顺序存储序列
     * @param rootIndex 序列根结点的索引
     * @return
     */
    public BiTreeNode createTree(String sqBiTree, int rootIndex) {

        BiTreeNode root = null;
        //检查根结点的索引是否越界
        if (rootIndex < sqBiTree.length()) {
            root = new BiTreeNode(sqBiTree.charAt(rootIndex));

            //在完全二叉树中(有n个结点)，第 i个结点的双亲结点的索引是 （i-1）/2,
            //如果 2*i+1 < n , 则 第i个结点的左子结点索引是：2*i+1
            root.LChild = createTree(sqBiTree, (2 * rootIndex + 1));
            //如果 2*i+2 < n , 则 第i个结点的右子结点索引是：2*i+2
            root.RChild = createTree(sqBiTree, (2 * rootIndex + 2));
        }
        return root;
    }


    public static void main(String[] args) {
        Example5_7 example5_7 = new Example5_7();
        BiTreeNode root = example5_7.createTree("ABCDEFGH", 0);

        LinkBiTree tree=new LinkBiTree(root);
        System.out.println("中序遍历");
        tree.inOrderTraverse();

        System.out.println();
        System.out.println("树的深度");

        int treeDepth2 = tree.getTreeDepth2();
        System.out.println(treeDepth2);


    }
}
