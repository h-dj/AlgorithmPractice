package org.hdj.AlgorithmPractice.Tree.LinkTree;

/**
 * 二叉树结点存储结构（二叉链式结点）
 * <p>
 */
public class BiTreeNode<T> {
    public T data; //结点数据域
    public BiTreeNode<T> LChild, RChild; //结点的左右子域

    public BiTreeNode() {
        this(null);
    }

    public BiTreeNode(T data) {
        this(data, null, null);
    }

    public BiTreeNode(T data, BiTreeNode<T> LChild, BiTreeNode<T> RChild) {
        this.data = data;
        this.LChild = LChild;
        this.RChild = RChild;
    }
}
