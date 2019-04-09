package org.hdj.AlgorithmPractice.DataStructure.Sort;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Auther: h_dj
 * @Date: 2019/4/9 10:01
 * @Description: 基数排序
 */
public class RadixSortTest {
    @Test
    public void radixSort() throws Exception {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};

        RadixSort.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}