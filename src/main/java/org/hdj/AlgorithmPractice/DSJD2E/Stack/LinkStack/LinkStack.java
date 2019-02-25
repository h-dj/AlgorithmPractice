package org.hdj.AlgorithmPractice.DSJD2E.Stack.LinkStack;

import org.hdj.AlgorithmPractice.DSJD2E.Stack.IStack;

/**
 * 链式栈
 */
public class LinkStack<E> implements IStack<E> {

    //栈顶指针
    private LNode<E> top;
    //栈的长度
    private int length;

    /**
     * 置空栈
     */
    @Override
    public void clear() {
        top = null;
    }

    /**
     * 判空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return length;
    }

    /**
     * 返回栈顶元素
     *
     * @return
     */
    @Override
    public E peek() {
        if (top != null) {
            return top.data;
        }
        return null;
    }

    /**
     * 进栈
     *
     * @param e
     */
    @Override
    public void push(E e) {
        //创建节点
        LNode node = new LNode(e);
        //插入新节点到链表的头部
        node.next = top;
        top = node;
        //栈长度加一
        length++;
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public E pop() {
        //判断栈是否为空
        if (!isEmpty()) {
            E data = top.data;
            top = top.next;
            length--;
            return data;
        }
        return null;
    }

    @Override
    public void display() {
        LNode<E> node = this.top;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
