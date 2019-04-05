package org.hdj.AlgorithmPractice.DataStructure.Stack.SqStack;

import org.hdj.AlgorithmPractice.DataStructure.Stack.IStack;

/**
 * 顺序栈
 */
public class SqStack<E> implements IStack<E> {

    //对象数据
    private Object[] elementData;
    //栈顶指针
    private int top;


    public SqStack() {
        this(10);
    }

    public SqStack(int iniCapacity) {
        this.elementData = new Object[iniCapacity];
        top = 0;
    }

    /**
     * 置空栈
     */
    @Override
    public void clear() {
        //清空元素，帮助垃圾回收
        for (int i = 0; i < top; i++) {
            elementData[i] = null;
        }
        //栈指针重置
        top = 0;
    }

    /**
     * 判空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * 栈长度
     *
     * @return
     */
    @Override
    public int size() {
        return top;
    }

    /**
     * 读取栈顶元素
     *
     * @return
     */
    @Override
    public E peek() {
        //判断是否为空栈
        if (isEmpty())
            throw new RuntimeException("栈为空！");
        return (E) elementData[top - 1];  //返回栈顶元素;
    }

    /**
     * 入栈
     *
     * @param e
     */
    @Override
    public void push(E e) {
        //检查栈是否已满
        if (top == elementData.length)
            throw new RuntimeException("栈已满！");
        //存储元素
        elementData[top] = e;
        //栈顶指针 加一
        top++;
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public E pop() {
        E peek = peek();
        //置空出栈元素
        elementData[top - 1] = null;
        //栈顶指针减一
        top--;
        return peek;
    }

    @Override
    public void display() {
        for (int i = top - 1; i >= 0; --i) {
            System.out.println(elementData[i].toString());
        }
    }
}
