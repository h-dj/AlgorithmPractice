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

        if(arr == null || arr.length == 0){
                return;
        }

        //堆化处理
        int leaf = arr.length/2-1;
        // 从最后一个非叶子结点开始（叶结点自然不用调整，第一个非叶子结点 arr.length/2-1，从左至右，从下至上进行调整。
        for (int i = leaf; i >=0; i--) {
            siftDown(arr,i);
        }

    }


    private static void siftDown(int[] arr, int start) {
            //非叶子节点
            int half = arr.length / 2;
            //遍历当前这棵子树
        while (start < half){
            //找到左孩子节点
            int child = ( start << 1) + 1;
            int c = arr[child];

            //判断左右节点那个大
            int right = child + 1;
            if (right < arr.length && arr[child] < arr[right]){

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
