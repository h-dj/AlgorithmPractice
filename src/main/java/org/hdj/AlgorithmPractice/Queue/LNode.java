package org.hdj.AlgorithmPractice.Queue;

/**
 * 队列节点
 */
public class LNode<T> {
    //数据域
    public T data;
    //指针域
    public LNode next;
    public LNode(T data) {
        this(data, null);
    }
    public LNode(T data, LNode next) {
        this.data = data;
        this.next = next;
    }
}
