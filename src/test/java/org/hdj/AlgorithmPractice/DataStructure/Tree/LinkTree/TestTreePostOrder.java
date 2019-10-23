package org.hdj.AlgorithmPractice.DataStructure.Tree.LinkTree;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author hdj
 * @version 1.0
 * @date 10/23/19 3:38 PM
 * @description:　练习后序遍历
 */
public class TestTreePostOrder {


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
     * 左右中
     *
     * @param root
     */
    public void postOrderTravese(BiTreeNode<String> root) {
        if (root == null) {
            return;
        }
        postOrderTravese(root.LChild);
        postOrderTravese(root.RChild);
        System.out.print(root.data + " ");
    }

    /**
     * 非递归
     *
     * @param root
     */
    public void postOrderTravese2(BiTreeNode<String> root) {
        if (root == null) {
            return;
        }
        LinkedList<BiTreeNode<String>> stack = new LinkedList<>();
        stack.push(root);
        BiTreeNode<String> node = null;
        //是否已访问
        boolean flag = false;
        //已访问节点指针
        BiTreeNode<String> p = null;

        while (!stack.isEmpty()) {

            while (stack.peek() != null) {
                stack.push(stack.peek().LChild);
            }
            stack.pop();

            while (!stack.isEmpty()) {
                node = stack.peek();

                if (node.RChild == null || node.RChild == p) {

                    stack.pop();
                    System.out.print(node.data + " ");
                    flag = true;
                    p = node;

                } else {
                    flag = false;
                    stack.push(node.RChild);
                }

                //右节点遍历完，退出
                if (!flag) {
                    break;
                }
            }

        }

    }

    @Test
    public void test() {
        postOrderTravese(tree.root);
        System.out.println();
        postOrderTravese2(tree.root);
    }
}
