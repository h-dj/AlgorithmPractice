package org.hdj.AlgorithmPractice.DataStructure.Tree.LinkTree;

import org.junit.Before;
import org.junit.Test;

public class LinkBiTreeTest {


    public LinkBiTree<String> tree;

    @Before
    public void setUp() throws Exception {
        BiTreeNode<String> d = new BiTreeNode<>("D");
        BiTreeNode<String> g = new BiTreeNode<>("G");
        BiTreeNode<String> h = new BiTreeNode<>("H");
        BiTreeNode<String> e = new BiTreeNode<>("E", g, null);
        BiTreeNode<String> b = new BiTreeNode<>("B", d, e);
        BiTreeNode<String> f = new BiTreeNode<>("F", null, h);
        BiTreeNode<String> c = new BiTreeNode<>("C", f, null);
        BiTreeNode<String> a = new BiTreeNode<>("A", b, c);
        tree = new LinkBiTree<>(a);
    }

    @Test
    public void preOrderTraverse() throws Exception {
        tree.preOrderTraverse(tree.root);
    }

    @Test
    public void preOrderTraverse1() throws Exception {
        tree.preOrderTraverse();
    }

    @Test
    public void inOrderTraverse() throws Exception {
    }

    @Test
    public void inOrderTraverse1() throws Exception {
    }

    @Test
    public void postOrderTraverse() throws Exception {
    }

    @Test
    public void postOrderTraverse1() throws Exception {
    }

    @Test
    public void levelTraverse() throws Exception {
    }

    @Test
    public void searchBiTreeNode() throws Exception {

        BiTreeNode node = tree.searchBiTreeNode("H");
        System.out.println(node.toString());
    }

    @Test
    public void countTreeNode() throws Exception {
        int i = tree.countTreeNode();
        System.out.println(i);

        int b = tree.countTreeNode2();
        System.out.println(b);

        int l = tree.countTreeLeaf();
        System.out.println(l);
    }

    @Test
    public void getTreeDepth() throws Exception {

        int treeDepth = tree.getTreeDepth(tree.root);
        System.out.println(treeDepth);

        int treeDepth2 = tree.getTreeDepth2();

        System.out.println(treeDepth2);
    }

    @Test
    public void LinkBiTreeTest() {
//        String preOrder = "ABDEGCFH";
//        String inOrder = "DBGEAFHC";
//
//        LinkBiTree linkBiTree = new LinkBiTree(preOrder, inOrder, 0, 0, preOrder.length());
//
//        System.out.println("后序遍历为：");
//        linkBiTree.postOrderTraverse();
//
//        System.out.println();

        String preStr = "AB##CD###";
        LinkBiTree biTree = new LinkBiTree(preStr);

        System.out.println("\n前序遍历：");
        biTree.preOrderTraverse();
        System.out.println("\n中序遍历：");
        biTree.inOrderTraverse();
        System.out.println("\n后序遍历：");
        biTree.postOrderTraverse();
    }

}