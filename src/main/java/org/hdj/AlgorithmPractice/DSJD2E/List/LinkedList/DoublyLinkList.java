package org.hdj.AlgorithmPractice.DSJD2E.List.LinkedList;

import org.hdj.AlgorithmPractice.DSJD2E.List.IList;

/**
 * @Auther: h_dj
 * @Date: 2019/3/25 16:14
 * @Description: 双向链表
 */
public class DoublyLinkList<E> implements IList<E> {

    //头结点
    private DuLNode<E> head;
    //链表长度
    private int length;


    public DoublyLinkList() {
        this.head = new DuLNode<>();
        this.length = 0;
    }

    @Override
    public void clear() {
        this.head = new DuLNode<>();
        this.length = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int size() {
        return this.length;
    }

    //获取元素
    @Override
    public E get(int i) {
        //先判断索引是否合法
        if (i < 0 || i > length - 1)
            throw new RuntimeException("查找的元素不存在！i=" + i);
        //获取第一个元素结点
        DuLNode<E> p = head.next;
        //下标
        int index = 0;
        //找到第i个元素
        while (p != null && index < i) {
            index++;
            p = p.next;
        }
        return p.data;
    }

    /**
     * 插入元素
     *
     * @param i
     * @param t
     */
    @Override
    public void insert(int i, E t) {
        //先判断索引是否合法
        if (i < 0 || i > length)
            throw new RuntimeException("插入元素的位置不合法！ i=" + i);
        DuLNode<E> p = head;
        //下标
        int index = -1;
        //找到第i个元素
        while (p.next != null && index < i) {
            index++;
            p = p.next;
        }
        //创建一个新的结点
        DuLNode<E> newNode = new DuLNode<>(t);
        if (i == 0 || i == length) {
            newNode.prior = p;
            p.next = newNode;
        } else {
            //1. 第i个结点p的前驱结点的后继指向新结点
            p.prior.next = newNode;
            //2. 新结点的前驱指向第(i-1)个结点
            newNode.prior = p.prior;
            //3. 新结点的后驱指向第i个结点p
            newNode.next = p;
            //4. 第i个结点p的前驱指向新结点
            p.prior = newNode;
        }
        //长度加一
        length++;
    }

    @Override
    public E remove(int i) {

        //先判断索引是否合法
        if (i < 0 || i > length - 1)
            throw new RuntimeException("删除元素不存在！ i=" + i);

        DuLNode<E> p = head;
        //下标
        int index = -1;
        //找到第i个元素
        while (p.next != null && index < i) {
            index++;
            p = p.next;
        }

        DuLNode<E> remove = p;

        //1. 第（i-1）个结点的后驱指向 第 （i+1）个结点
        p.prior.next = p.next;
        //2. 第 （i+1）个结点的前驱指向 第（i-1）个结点
        p.next.prior = p.prior;

        //长度减一
        length--;
        return remove.data;
    }

    @Override
    public int indexOf(E t) {
        DuLNode<E> p = head.next;
        //下标
        int index = 0;
        //找到第i个元素
        while (p != null) {
            if (p.data.equals(t)) {
                return index;
            }
            index++;
            p = p.next;
        }
        return -1;
    }

    @Override
    public void display() {
        DuLNode<E> p = head.next;
        //找到第i个元素
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }
}
