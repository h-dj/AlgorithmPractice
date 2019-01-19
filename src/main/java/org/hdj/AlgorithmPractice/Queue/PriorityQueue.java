package org.hdj.AlgorithmPractice.Queue;

/**
 * 优先队列
 */
public class PriorityQueue<T extends PriorityQueueData> extends LinkQueue<T> {
    public PriorityQueue() {
        front = rear = null;
    }
    /**
     * 入队列
     *
     * @param t
     */
    @Override
    public void offer(T t) {
//        构造新节点
        LNode<T> node = new LNode(t);
        //if the queue is empty
        if (isEmpty()) {
            front = rear = node;
        } else {
            //遍历队列的指针
            LNode<T> p = front;
            //获取要插入队列的位置节点指针
            LNode<T> q = front;

            //新节点优先级与队列节点比较
            while (p != null && t.priority >= p.data.priority) {
                q = p;
                p = p.next;
            }
            //如果 p为空，则遍历到了队尾，则将新节点插入队尾
            if (p == null) {
                rear.next = node;
                rear = node;
            } else if (p == front) { //新节点的优先级大于队首节点，插入队首
                node.next = front.next;
                front = node;
            } else {  //插入新节点到对应优先级的位置
                node.next = q.next;
                q.next = node;
            }
        }
        //长度加一
        ++length;
    }
}
