package org.hdj.AlgorithmPractice.Tree.LinkTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

}