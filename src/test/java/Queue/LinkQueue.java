package Queue;

/**
 * 链式队列
 *
 * @param <T>
 */
public class LinkQueue<T> implements IQueue<T> {

    /**
     * 队头指针
     */
    private LNode<T> front;
    /**
     * 队尾指针
     */
    private LNode<T> rear;


    public LinkQueue() {
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public void offer(T t) {

    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public void display() {

    }
}
