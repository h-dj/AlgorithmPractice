package org.hdj.AlgorithmPractice.SwordOffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hdj
 * @version 1.0
 * @date 10/21/19 3:25 PM
 * @description:　测试　查找重复数字在数组中
 */
public class DuplicationInArrayTest {

    @Test
    public void findDuplication() {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int length = numbers.length;
        int[] duplications = new int[1];
        boolean dubplication = DuplicationInArray.findDuplication(numbers, length, duplications);
        if (dubplication) {
            System.out.println(Arrays.toString(duplications));
        }

    }

    @Test
    public void NullCase() {
        int[] numbers = null;
        int length = 8;
        int[] duplications = new int[1];
        boolean dubplication = DuplicationInArray.findDuplication(numbers, length, duplications);

        System.out.println("是否有重复:" + dubplication);
        if (dubplication) {
            System.out.println(Arrays.toString(duplications));
        }
    }
}