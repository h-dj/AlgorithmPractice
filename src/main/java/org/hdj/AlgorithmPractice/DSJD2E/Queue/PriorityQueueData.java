package org.hdj.AlgorithmPractice.DSJD2E.Queue;

/**
 * 优先队列数据节点
 */
public class PriorityQueueData<T> {

    public T t; //数据
    public int priority;//优先级

    public PriorityQueueData(T t) {
        this(t, 0);
    }

    public PriorityQueueData(T t, int priority) {
        this.t = t;
        this.priority = priority;
    }
    @Override
    public String toString() {
        return "PriorityQueueData{" +
                "t=" + t +
                ", priority=" + priority +
                '}';
    }
}
