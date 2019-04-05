package org.hdj.AlgorithmPractice.DataStructure.Stack.LinkStack;

import org.hdj.AlgorithmPractice.DataStructure.Stack.IStack;

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
        length = 0;
    }

    /**
     * 判空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
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
        if (isEmpty())
            throw new RuntimeException("栈为空！");
        return top.data;
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
        //修改栈顶指针
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
        //获取栈顶元素
        E pop = peek();
        //修改栈顶指针
        top = top.next;
        //栈长度减一
        length--;
        return pop;
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
