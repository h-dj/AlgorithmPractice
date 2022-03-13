package org.hdj.AlgorithmPractice.LeetCode.algorithm;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author huangjiajian
 * @date 2022/3/13
 */
public class LFUCacheTest {

    @Test
    public void test_get(){
        LFUCache cache=new LFUCache(10);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(4,4);
        cache.put(5,5);
        cache.put(3,3);
        cache.display();

        System.out.println("=======访问后： ");
        for (int i = 0; i < 10; i++) {
            cache.get(new Random().nextInt(5));
        }

        cache.display();

    }

}