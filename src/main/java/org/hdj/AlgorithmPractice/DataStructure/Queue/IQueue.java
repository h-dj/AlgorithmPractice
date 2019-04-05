package org.hdj.AlgorithmPractice.DataStructure.Queue;

/**
 * 队列接口
 */
public interface IQueue<T> {
    void clear();//清空队列

    boolean isEmpty();//判断空队列

    int size();//队列长度

    T peek(); //读取队首元素

    void offer(T t);//入队列


    T poll();//出队列

    void display();//打印
}
