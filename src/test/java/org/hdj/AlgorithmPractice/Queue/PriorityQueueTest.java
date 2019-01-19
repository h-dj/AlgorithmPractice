package org.hdj.AlgorithmPractice.Queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {
    @Test
    public void offer() throws Exception {
        PriorityQueue pm = new PriorityQueue();
        pm.offer(new PriorityQueueData(1, 0));
        pm.offer(new PriorityQueueData(2, 60));
        pm.offer(new PriorityQueueData(3, 10));
        pm.offer(new PriorityQueueData(4, 20));
        pm.offer(new PriorityQueueData(5, 30));

        pm.display();

        System.out.println();
        System.out.println(pm.size());

        Object poll = pm.poll();
        System.out.println(poll);

        System.out.println();
        System.out.println(pm.size());
    }
}