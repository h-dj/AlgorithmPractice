package org.hdj.AlgorithmPractice.DSJD2E.Stack.LinkStack;

/**
 * 链表的节点数据结构
 */
public class LNode<T> {

    //数据域
    public T data;
    //指针域
    public LNode<T> next;

    public LNode() {
        this(null, null);
    }

    public LNode(T data) {
        this(data, null);
    }

    public LNode(T data, LNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
