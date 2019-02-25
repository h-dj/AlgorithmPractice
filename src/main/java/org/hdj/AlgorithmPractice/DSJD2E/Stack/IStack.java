package org.hdj.AlgorithmPractice.DSJD2E.Stack;

/**
 * 栈抽象数据接口
 */
public interface IStack<E> {

    /**
     * 清空栈
     */
    public void clear();

    /**
     * 是否空栈
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * 栈数据元素的个数
     *
     * @return
     */
    public int size();

    /**
     * 读取栈顶元素
     *
     * @return
     */
    public E peek();

    /**
     * 进栈
     *
     * @param e
     */
    public void push(E e);

    /**
     * 出栈，并返回该元素。
     *
     * @return
     */
    public E pop();

    /**
     * 打印
     */
    public void display();
}
