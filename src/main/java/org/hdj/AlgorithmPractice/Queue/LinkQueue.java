package org.hdj.AlgorithmPractice.Queue;

/**
 * 链式队列（不带头结点）
 *
 * @param <T>
 */
public class LinkQueue<T> implements IQueue<T> {
    /**
     * 队头指针
     */
    protected LNode<T> front;
    /**
     * 队尾指针
     */
    protected LNode<T> rear;

    /**
     * 链表队列长度
     */
    protected int length;

    public LinkQueue() {
        front = rear = null;
    }

    /**
     * 清空链式队列
     */
    @Override
    public void clear() {

        /**
         * 置空节点，帮助垃圾回收
         */
        while (front != rear) {
            LNode<T> temp = this.front;
            temp.data = null;
            temp.next = null;
            this.front = this.front.next;
        }
        front = rear = null;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    /**
     * 读取队头元素
     *
     * @return
     */
    @Override
    public T peek() {
        //判断是否为空队列
        if (isEmpty())
            throw new RuntimeException("队列为空！");
        return front.data;
    }

    /**
     * 入队列（尾插法）
     *
     * @param t
     */
    @Override
    public void offer(T t) {
//        创建节点
        LNode<T> node = new LNode<T>(t);

        //判断队列是否为空,空则赋值为队首和队尾指针
        if (isEmpty()) {
            front = rear = node;
        } else {
            //不为空，则插入队尾
            //队列的尾节点的指针指向新节点
            rear.next = node;
            //尾指针指向新节点，作为新尾节点4
            rear = node;
        }

        //长度加一
        ++length;
    }

    /***
     * 出队列
     * @return
     */
    @Override
    public T poll() {
        //判断是否为空队列
        if (isEmpty()) throw new RuntimeException("队列为空！");
        //获取队头节点
        LNode<T> head = this.front;
        //头指针指向队头节点的指针指向的节点
        this.front = head.next;
        //置空指针引用
        head.next = null;
        if (head == rear) rear = null;

        //长度减一
        --length;

        //返回数据
        return head.data;
    }

    /**
     * 打印
     */
    @Override
    public void display() {
        if (!isEmpty()) {
            LNode<T> next = this.front;
            while (next != null) {
                System.out.println(next.data);
                next = next.next;
            }
        }
    }
}
