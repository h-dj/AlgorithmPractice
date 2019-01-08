package org.hdj.AlgorithmPractice.List.LinkedList;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import org.hdj.AlgorithmPractice.List.IList;

/**
 * 单链表的实现
 *
 * @param <T>
 */
public class LinkedList<T> implements IList<T> {

    //链表的头指针
    public LNode<T> head;

    public LinkedList() {
        //初始化带头结点的单链表
        this.head = new LNode<T>();
    }

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        //先从头指针，开始遍历
        //如果节点的指针域为空，则遍历到链表尾部
        for (LNode x = head; x.next!= null; ) {
            //获取节点
            LNode node = x.next;
            //置空节点数据域和指针域，帮助垃圾回收
            x.next = null;
            x.data = null;
            //继续下一个节点
            x = node;
        }
        //置空头指针
        head.next = null;
        head.data = null;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public int size() {
        //获取首节点
        LNode node = head.next;
        //计数器
        int length = 0;
        //遍历节点
        while (node != null) {
            node = node.next;
            length++;
        }

        return length;
    }


    /**
     * 链表查找操作
     * 按序号查找
     * <p>
     * 时间复杂度：O(n)
     *
     * @param i
     * @return
     */
    @Override
    public T get(int i) {
        //获取第一个节点元素
        LNode node = head.next;
        //计数器
        int pos = 0;
        //遍历节点，直到节点为空 或者 指向第 i 个节点退出循环
        while (node != null && pos < i) {
            node = node.next; //指向后继节点
            ++pos;//计数器加一
        }
        //判断是否找到节点
        if (node == null || pos > i)
            throw new RuntimeException("第 " + i + " 个元素不存在！");

        return (T) node.data;
    }

    /**
     * 插入元素到指定下标
     * <p>
     * 插入步骤
     * 1. 找到插入位置 i 的前驱节点
     * 2. 创建一个新的节点
     * 3. 新节点的指针指向 原先 第 i个节点， 原第i 节点的前驱节点的指针指向新节点
     * <p>
     * 时间复杂度为; O(n)
     * <p>
     * 在不带头结点的链表中，执行插入操作需要多做一步操作
     * <h1>1. 如果插入表头时</h1>
     * LNode newNode = new LNode(t);
     * newNode.next = head;
     * head.next = newNode;
     * <p>
     * <h1>如果插入表中或表尾时，p: 第 (i-1)个节点 </h1>
     * LNode newNode = new LNode(t);
     * newNode.next = p.next;
     * p.next = newNode;
     *
     * @param i
     * @param t
     */
    @Override
    public void insert(int i, T t) {
        LNode p = head;
        int pos = -1;
        //1. 找到第 (i-1)个节点(位置 i 的前驱节点)
        while (p.next != null && pos < i - 1) {
            p = p.next;
            pos++;
        }

        //判断插入位置的合法性
        if (p == null && pos > i - 1)
            throw new RuntimeException("插入节点的位置不合法！");

        //2. 创建一个新的节点
        LNode newNode = new LNode(t);
        //3.1 新节点的后继指针指向 原先第 i个节点
        newNode.next = p.next;
        //3.2  第（i-1）节点 p 的后继指针指向新节点
        p.next = newNode;
    }

    /**
     * 头部插入法
     */
    public void insertAtHead(T t) {
        //构建新插入的节点
        LNode newNode = new LNode(t);
        //新节点的后继指针指向头结点的头指针
        newNode.next = head.next;
        //头指针指向新节点
        head.next = newNode;
    }

    /**
     * 尾部插入法
     *
     * @param t
     */
    public void insertTail(T t) {
        //获取到最后的节点
        LNode tail = this.head;
        while (tail.next != null) {
            tail = tail.next;
        }
        //构造新的节点
        LNode newNode = new LNode(t);
        //新节点指针指向 尾节点指针
        newNode.next = tail.next;
        //尾节点指针指向新节点
        tail.next = newNode;
    }

    /**
     * 链表的删除操作
     * <p>
     * 主要步骤
     * <p>
     * 1. 先判断链表是否为空， 否则执行第二步
     * 2. 找到待删除节点的前驱节点
     * 3. 把前驱节点的 指针指向待删除节点的指针指向的节点
     * <p>
     * 时间复杂度： O(n)
     *
     * @param i
     * @return
     */
    @Override
    public T remove(int i) {

        LNode p = head;
        int pos = -1;
        //找到待删除节点的前驱节点
        while (p.next != null && pos < i - 1) {
            p = p.next;
            ++pos;
        }

        if (pos > i - 1 || p == null)
            throw new RuntimeException("删除节点的位置不合法！");
        //待删除节点
        LNode remove = p.next;
        //3. 第 （i-1) 节点的指针指向 (i+1)节点
        p.next = remove.next;
        return (T) remove.data;
    }

    /**
     * 按值查找节点的下标
     * <p>
     * 时间复杂度为： O(n)
     *
     * @param t
     * @return
     */
    @Override
    public int indexOf(T t) {
        //获取第一个节点元素
        LNode node = head.next;
        //计数器
        int pos = 0;

        //判断查询的值是否为空
        if (t == null) {
            //遍历节点，直到节点为空 或者 节点的数据域为空，退出循环
            while (node != null && node.data != null) {
                node = node.next; //指向后继节点
                ++pos;//计数器加一
            }
        } else {
            //遍历节点，直到节点为空 或者 指向值为 t的 节点退出循环
            while (node != null && !t.equals(node.data)) {
                node = node.next; //指向后继节点
                ++pos;//计数器加一
            }
        }
        return node != null ? pos : -1;
    }

    /**
     * 打印链表元素
     */
    @Override
    public void display() {
        //获取第一个节点
        LNode node = head.next;
        //遍历打印
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }

        System.out.println();
    }
}
