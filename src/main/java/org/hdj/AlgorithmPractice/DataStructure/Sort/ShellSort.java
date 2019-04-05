package org.hdj.AlgorithmPractice.DataStructure.Sort;

import java.util.Arrays;

/**
 * @Auther: h_dj
 * @Date: 2019/2/12 10:00
 * @Description: 希尔排序
 */
public class ShellSort {

    /**
     * 希尔排序
     * <p>
     * 时间复杂度： O(nlog2n)
     *
     * @param elements 待排序的序列
     * @param d        增量集合
     */
    public static void shellSort(int[] elements, int[] d) {
        int i, j;
        for (int k = 0; k < d.length; k++) {

            //对每个子表中的记录进行直接插入排序
            int dk = d[k];
            for (i = 0; i < elements.length; i++) {
                //存临时变量
                int temp = elements[i];
                //移动
                for (j = i - dk; j >= 0 && temp < elements[j]; j -= dk) {
                    elements[j + dk] = elements[j];
                }
                elements[j + dk] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] elements = {52, 39, 67, 95, 70, 8, 25, 52, 56, 5};
        int[] d = {6, 3, 1};

        shellSort(elements, d);

        System.out.println(Arrays.toString(elements));
    }
}
