package org.hdj.AlgorithmPractice.DataStructure.Tree.LinkTree;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author hdj
 * @version 1.0
 * @date 10/23/19 1:44 PM
 * @description:　练习二叉树的前序遍历
 */
public class TestTreePreOrder {


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

    /**
     * 前序遍历(递归形式)
     * <p>
     * 中左右
     */
    public void preOrderTraverse(BiTreeNode<String> root) {
        if (root == null) {
            return;
        }
        //访问数据
        System.out.print(root.data + " ");
        //在访问左节点
        preOrderTraverse(root.LChild);
        //最后访问右节点
        preOrderTraverse(root.RChild);
    }


    /**
     * 非递归形式
     */
    public void preOrderTraverse2(BiTreeNode<String> root) {
        if (root == null) {
            return;
        }

        LinkedList<BiTreeNode<String>> stack = new LinkedList<>();

        stack.push(root);
        BiTreeNode<String> node;
        while (!stack.isEmpty()) {
            node = stack.pop();

            //访问
            System.out.print(node.data + " ");

            //访问左节点，直到没有左节点
            //才访问右节点
            while (node != null) {

                if (node.LChild != null) {
                    System.out.print(node.LChild.data + " ");
                }

                if (node.RChild != null) {
                    stack.push(node.RChild);
                }

                node = node.LChild;
            }
        }
    }


    @Test
    public void test() {
        preOrderTraverse(tree.root);
        System.out.println();
        preOrderTraverse2(tree.root);
    }
}
