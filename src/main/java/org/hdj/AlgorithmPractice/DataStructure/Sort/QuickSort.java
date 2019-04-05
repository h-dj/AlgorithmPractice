package org.hdj.AlgorithmPractice.DataStructure.Sort;

import java.util.Arrays;

/**
 * @Auther: h_dj
 * @Date: 2019/2/12 10:54
 * @Description: 快速排序
 */
public class QuickSort {

    /**
     * @param i
     * @param j
     * @return
     */
    public static int partition(int[] elements, int i, int j) {

        int pivot = elements[i];
        //从表的两端向中间扫描
        while (i < j) {
            //找到elements[i] <= elements[j]的下标
            while (i < j && pivot <= elements[j]) {
                j--;
            }

            //当elements[i] <= elements[j], 交换位置
            if (i < j) {
                elements[i] = elements[j];
                i++;
            }

            // elements[i] > elements[j]的下标
            while (i < j && pivot > elements[i]) {
                i++;
            }

            //当elements[i] > elements[j], 交换位置
            if (i < j) {
                elements[j] = elements[i];
                j--;
            }
        }
        //支点记录到位
        elements[i] = pivot;
        //返回支点下标
        return i;
    }

    /**
     * 快速排序
     *
     * @param elements 待排序列
     * @param low
     * @param hight
     */
    public static void qSort(int[] elements, int low, int hight) {
        if (low < hight) {
            int pivotloc = partition(elements, low, hight);
            // 低子表排序
            qSort(elements, low, pivotloc - 1);
            //高子表排序
            qSort(elements, pivotloc + 1, hight);
        }
    }

    public static void main(String[] args) {
        int[] elements = {1, 4, 2, 3, 5, 6};

        qSort(elements, 0, elements.length - 1);

        System.out.println(Arrays.toString(elements));

    }
}
