package org.hdj.AlgorithmPractice.DataStructure.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: h_dj
 * @Date: 2019/2/9 22:56
 * @Description: 插入排序
 */
public class InsertSort {

    /**
     * 没有设置哨兵的插入排序
     *
     * @param elements
     */
    public void sortNoGuard(int[] elements) {
        int i, j;
        for (i = 1; i < elements.length; i++) {
            //1. 将r[i]存放在临时变量temp中
            int temp = elements[i];
            //2. 将r[j] 与temp比较，当temp >=r[j], 将r[j]往后移
            for (j = i - 1; j >= 0 && temp < elements[j]; j--) {
                elements[j + 1] = elements[j];
            }
            //3. 将temp插入j+1的位置
            elements[j + 1] = temp;
        }
    }

    /**
     * 插入算法改进
     */
    public void sortWithGuard(int[] elements) {
        int i, j;
        int len = elements.length;
        for (i = 2; i < len; i++) {
            //elements[0]充当哨兵，避免边界判断
            elements[0] = elements[i];

            for (j = i - 1;  elements[0] < elements[j]; j--) {
                elements[j + 1] = elements[j];
            }
            //3. 将elements[i]插入j+1的位置
            elements[j + 1] = elements[0];

        }
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();

        int[] arr = new int[10];

        for (int i = 1; i < 10; i++) {
            arr[i] = new Random().nextInt(100);
        }

        long start = System.currentTimeMillis();
       // shellSort.sortNoGuard(arr);//113.888
          sort.sortWithGuard(arr);//116.891
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);
       System.out.println(Arrays.toString(arr));


    }
}
