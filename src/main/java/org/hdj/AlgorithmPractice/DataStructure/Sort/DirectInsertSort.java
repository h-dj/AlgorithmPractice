package org.hdj.AlgorithmPractice.DataStructure.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: h_dj
 * @Date: 2019/2/9 22:56
 * @Description: 直接插入排序
 */
public class DirectInsertSort {

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
     * 需要预留数组第一个充当哨兵
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
}
