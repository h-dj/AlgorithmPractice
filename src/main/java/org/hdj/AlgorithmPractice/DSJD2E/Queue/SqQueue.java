package org.hdj.AlgorithmPractice.DSJD2E.Queue;

/**
 * 顺序队列的实现
 *
 * @param <T>
 */
public class SqQueue<T> implements IQueue<T> {
    /**
     * 队列容器
     */
    private Object[] queues;

    /**
     * 队首指针
     */
    private int front;
    /**
     * 队尾指针
     */
    private int rear;

    public SqQueue() {
        this(10);
    }

    public SqQueue(int initCapacity) {
        queues = new Object[initCapacity];
    }


    /**
     * 清空队列
     */
    @Override
    public void clear() {
        //置空队列容器，帮助垃圾回收
        for (int i = 0; i < queues.length; i++) {
            queues[i] = null;
        }
        //重置指针
        front = rear = 0;
    }

    /**
     * 判空(采用少存一个存储单元的方式)
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 队列长度
     *
     * @return
     */
    @Override
    public int size() {
        return (rear - front + queues.length) % queues.length;
    }

    /**
     * 读取队首元素
     *
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("队列为空！");
        return (T) queues[front];
    }

    /**
     * 入队列
     *
     * @param t
     */
    @Override
    public void offer(T t) {
        //判断队列是否超出队列容量
        if ((rear + 1) % queues.length == front)
            throw new RuntimeException("队列溢出！");
        //入队
        queues[rear] = t;
        //队尾指针指向队尾后一个元素
        rear = (rear + 1) % queues.length;
    }

    /**
     * 出队列
     *
     * @return
     */
    @Override
    public T poll() {
        //判断队列是否为空
        if (isEmpty()) new RuntimeException("队列为空！");

        //获取队首元素
        Object queue = queues[front];
        queues[front] = null;

        //队头指针指向下一个元素
        front = (front + 1) % queues.length;

        return (T) queue;
    }

    /**
     * 打印队列
     */
    @Override
    public void display() {
        if (!isEmpty()) {
            for (Object queue : queues) {
                System.out.println(queue.toString());
            }
        }
    }
}
