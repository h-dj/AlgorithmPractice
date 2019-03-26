package org.hdj.AlgorithmPractice.DSJD2E.Queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: h_dj
 * @Date: 2019/3/26 15:35
 * @Description:
 */
public class LinkQueueTest {
    LinkQueue<Integer> queue=new LinkQueue<>();
    @Before
    public void setUp() throws Exception {
        queue.offer(1);
    }

    @Test
    public void clear() throws Exception {
        queue.display();
        System.out.println("123111111111111111");
        queue.clear();
        queue.display();
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(queue.isEmpty());
    }

    @Test
    public void size() throws Exception {
    }

    @Test
    public void peek() throws Exception {
        queue.offer(2);
        Integer poll = queue.poll();
        queue.poll();
        System.out.println(queue.peek());

        System.out.println(poll);
    }

    @Test
    public void offer() throws Exception {
    }

    @Test
    public void poll() throws Exception {
    }

    @Test
    public void display() throws Exception {
    }

}