package org.hdj.AlgorithmPractice.DataStructure.Queue;

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
        this.length = 0;
    }

    /**
     * 清空链式队列
     */
    @Override
    public void clear() {
        front = rear = null;
        this.length = 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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
        //获取队首元素
        T poll = peek();
        //修改队首指针
        this.front = this.front.next;
        //长度减一
        this.length--;
        //返回数据
        return poll;
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
