package Queue;

/**
 * 队列抽象接口
 */
public interface IQueue<T> {

    /**
     * 清空队列
     */
    void clear();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 队列长队
     *
     * @return
     */
    int size();

    /**
     * 读取队首元素
     *
     * @return
     */
    T peek();

    /**
     * 入队列
     *
     * @param t
     */
    void offer(T t);

    /**
     * 出队列
     *
     * @return
     */
    T poll();

    void display();
}
