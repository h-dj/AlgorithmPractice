package org.hdj.AlgorithmPractice;

import org.hdj.AlgorithmPractice.DataStructure.Sort.DirectInsertSort;

import java.util.Arrays;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2022/2/28 9:54
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 9, 3, 4, 5};
//        directInsertSort(arr);
//        bubbleSort(arr);
//        directSelectSort(arr);
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 直接插入排序
     *
     * @param arr
     */
    public static void directInsertSort(int[] arr) {
        //遍历数组
        int i, j;
        for (i = 1; i < arr.length; i++) {
            //保存要比较的值
            int temp = arr[i];
            //如果当前的值比前面的值小，把比它大的元素往后移
            //插入对应的位置
            for (j = i - 1; j > 0 && temp < arr[i]; --j) {
                //后移
                arr[j + 1] = arr[j];
            }
            //插入对应的值
            arr[j + 1] = temp;
        }
    }

    /**
     * 冒泡插入排序
     * 56413
     * <p>
     * 54136
     */
    public static void bubbleSort(int[] arr) {
        boolean flag = true;
        for (int i = 1; i < arr.length && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 直接选择排序
     * <p>
     *
     * @param arr
     */
    public static void directSelectSort(int[] arr) {
        int i, j, minIndex;
        for (i = 0; i < arr.length; i++) {
            minIndex = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {


            int i = startIndex;
            int j = endIndex;

            int temp = arr[startIndex];
            while (i < j) {

                while (i < j && temp < arr[j]) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && temp > arr[i]) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = temp;
            quickSort(arr, startIndex, i);
            quickSort(arr, i + 1, endIndex);

        }


    }


}
