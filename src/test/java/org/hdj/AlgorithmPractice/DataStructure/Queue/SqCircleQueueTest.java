package org.hdj.AlgorithmPractice.DataStructure.Queue;

import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: h_dj
 * @Date: 2019/3/26 15:16
 * @Description:
 */
public class SqCircleQueueTest {

    private SqCircleQueue<Integer> queue=new SqCircleQueue<>();
    @Before
    public void setUp() throws Exception {
        queue.offer(1);
    }

    @Test
    public void clear() throws Exception {
        queue.display();
        queue.clear();
        queue.display();
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(queue.isEmpty());
    }

    @Test
    public void size() throws Exception {
        System.out.println(queue.size());
    }

    @Test
    public void peek() throws Exception {
        System.out.println(queue.peek());
    }

    @Test
    public void offer() throws Exception {
        queue.offer(2);
        queue.display();

        Integer poll = queue.poll();
        System.out.println(poll);
    }

    @Test
    public void poll() throws Exception {
    }

    @Test
    public void display() throws Exception {
    }

}