package org.hdj.AlgorithmPractice.SwordOffer;

import java.util.Arrays;

/**
 * @author hdj
 * @version 1.0
 * @date 10/22/19 3:51 PM
 * @description: 合并两个有序数组(与替换空格题目类似)
 * <p>
 * 有序数组A1 和A2, A1有足够的空间容纳A2, 实现一个函数把A2合并到A1,并保证有序
 */
public class MergeSortArray {

    /**
     * 合并两个有序数组
     *
     * @param A1
     * @param A2
     */
    public static void mergeSortArray(int[] A1, int[] A2) {
        //检查参数
        if (A1 == null
                || A2 == null
                || A1.length <= 0
                || A2.length <= 0
                || A1.length < A2.length) {
            return;
        }

        //统计一下A1已存的元素长度
        int a1Len = 0;
        for (int i = 0; i < A1.length; i++) {
            if (A1[i] == 0) {
                break;
            }
            a1Len++;
        }

        int a2Len = A2.length;
        //合并后的长度
        int mergeLen = a1Len + a2Len;


        int a1Pos = a1Len - 1;
        int a2Pos = a2Len - 1;
        int pos = mergeLen - 1;

        //比较两数组
        while (a2Pos >= 0 && a1Pos >= 0) {
            if (A1[a1Pos] >= A2[a2Pos]) {
                A1[pos--] = A1[a1Pos--];
            } else {
                A1[pos--] = A2[a2Pos--];
            }
        }
    }

    public static void main(String[] args) {
        int[] A1 = {1, 3, 4, 9, 10, 25, 0, 0, 0, 0, 0};
        int[] A2 = {2, 88, 99};

        mergeSortArray(A1, A2);

        System.out.println(Arrays.toString(A1));
    }

}
