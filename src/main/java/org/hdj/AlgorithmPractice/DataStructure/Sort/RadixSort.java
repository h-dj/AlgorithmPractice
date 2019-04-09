package org.hdj.AlgorithmPractice.DataStructure.Sort;

import java.util.Arrays;

/**
 * @Auther: h_dj
 * @Date: 2019/4/7 17:25
 * @Description: 基数排序
 */
public class RadixSort {

    /**
     * 获取序列最大值
     */
    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (max < array[i])
                max = array[i];
        return max;

    }

    /**
     * 按对数组按照"某个位数"进行排序
     *
     * @param arr 数组
     * @param n   数组长度
     * @param exp 排序的位数
     */
    private static void countSort(int[] arr, int n, int exp) {
        int output[] = new int[n]; //输出的数组
        int i;
        int count[] = new int[10];

        // 保存出现的次数
        //如：179,589 按个位排序（9） ；在count数组中的最后一个count[9] = 2;
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // 更改count[i]。目的是让更改后的count[i]的值，是该数据在output[]中的位置。
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // 将数据存储到临时数组output[]中
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 将排序好的数据赋值给a[]
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void radixSort(int arr[]) {
        //获取最大值
        int m = getMax(arr);
        //长度
        int n = arr.length;

        // 从个位开始，对数组a按"指数"进行排序
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

}
