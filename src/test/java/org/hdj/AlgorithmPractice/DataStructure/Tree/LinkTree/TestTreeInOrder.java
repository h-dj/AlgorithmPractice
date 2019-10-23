package org.hdj.AlgorithmPractice.DataStructure.Tree.LinkTree;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author hdj
 * @version 1.0
 * @date 10/23/19 2:32 PM
 * @description:　练习二叉树的中序遍历
 */
public class TestTreeInOrder {
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
     * 递归
     * <p>
     * 左中右
     *
     * @param root
     */
    public void inOrderTravese(BiTreeNode<String> root) {
        if (root == null) {
            return;
        }
        inOrderTravese(root.LChild);
        System.out.print(root.data + " ");
        inOrderTravese(root.RChild);
    }


    /**
     * 中序遍历，非递归
     */
    public void inOrderTravese2(BiTreeNode<String> root) {
        if (root == null) {
            return;
        }
        LinkedList<BiTreeNode<String>> stack = new LinkedList<>();
        stack.push(root);

        BiTreeNode<String> node = null;
        while (!stack.isEmpty()) {

            //入栈，直到最后的左节点
            while (stack.peek() != null) {
                stack.push(stack.peek().LChild);
            }
            //弹出空节点
            stack.pop();

            if (!stack.isEmpty()) {
                node = stack.pop();
                //打印结点
                System.out.print(node.data+" ");
                //把该结点的右子结点入栈
                stack.push(node.RChild);
            }

        }
    }

    @Test
    public void test() {
        inOrderTravese(tree.root);
        System.out.println();
        System.out.println("+");
        inOrderTravese2(tree.root);
    }
}
