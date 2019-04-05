package org.hdj.AlgorithmPractice.DataStructure.List.LinkedList;

/**
 * @Auther: h_dj
 * @Date: 2019/3/19 22:37
 * @Description: 双向链表结点
 */
public class DuLNode<E> {

    public E data;
    public DuLNode<E> prior;
    public DuLNode<E> next;


    public DuLNode() {
        this(null);
    }

    public DuLNode(E data) {
        this.data = data;
        this.prior = null;
        this.next = null;
    }
}
