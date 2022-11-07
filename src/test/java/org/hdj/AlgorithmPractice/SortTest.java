package org.hdj.AlgorithmPractice;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2022/2/28 9:54
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 9, 3, 4, 5};

//        插入排序	0(n^2)	0(n^2)	0(n)	0(1)	稳定
        //directInsertSort(arr);
//        希尔排序	0(n13)	0(n2)	0(n)	0(1)	不稳定
        //shellInsertSort(arr);
//        选择排序	0(n2)	0(n2)	0(n2)	0(1)	不稳定
        //directSelectSort(arr);
//        堆排序	O(nlog2n)	O(nlog2n)	O(nlog2n)	0(1)	不稳定
        headSort(arr);
//        冒泡排序	0(n2)	0(n2)	0(n)	0(1)	稳定
//        快速排序	O(nlog2n)	0(n2)	O(nlog2n)	O(nlog2n)	不稳定
//        归并排序	O(nlog2n)	O(nlog2n)	O(nlog2n)	0(n)	稳定
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    private static void headSort(int[] arr) {

        if (arr == null && arr.length == 0) {
            return;
        }

        //堆化处理
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, arr.length - 1);
        }

        //排序处理
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            siftDown(arr, 0, i-1);
        }
    }


    private static void siftDown(int[] arr, int start, int end) {
        //当前父节点
        int c = start;
        int temp = arr[c];
        //左孩子节点
        int left = 2 * c + 1;

        //调整位置
        for (; left <= end; c = left, left = 2 * left + 1) {

            //选出最大的节点
            if (left < end && arr[left] < arr[left + 1]) {
                left++;
            }

            if (temp >= arr[left]) {
                break;
            } else {
                //交换位置
                arr[c] = arr[left];
                arr[left] = temp;
            }
        }
    }


    /**
     * 直接选择排序
     *
     * @param arr
     */
    private static void directSelectSort(int[] arr) {
        if (arr == null && arr.length == 0) {
            return;
        }

        int i, j, len = arr.length;
        for (i = 0; i < len; i++) {
            int minIndex = i;
            for (j = len - 1; j > i; j--) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    //希尔排序实质上是一种分组插入方法。
    //希尔排序	0(n13)	0(n2)	0(n)	0(1)	不稳定
    private static void shellInsertSort(int[] arr) {
        int gap, i, j;
        int len = arr.length;
        for (gap = len / 2; gap > 0; gap /= 2) {
            for (i = gap; i < len; i++) {
                int temp = arr[i];
                for (j = i - gap; j > 0 && temp < arr[j]; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }

    }

    //        插入排序	0(n^2)	0(n^2)	0(n)	0(1)	稳定
    private static void directInsertSort(int[] arr) {
        //判空
        if (arr == null || arr.length == 0) {
            return;
        }
        int i, j;
        for (i = 1; i < arr.length; i++) {
            int temp = arr[i];

            //从 i 往前插入排序
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            //插入原来值
            arr[j + 1] = temp;
        }
    }


}
