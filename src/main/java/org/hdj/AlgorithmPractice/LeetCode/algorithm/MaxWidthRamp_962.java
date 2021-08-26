package org.hdj.AlgorithmPractice.LeetCode.algorithm;

import java.util.Arrays;

/**
 * @author hdj
 * @version 1.0
 * @date 09/06/2020 21:47
 * @description: 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 * <p>
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 */
public class MaxWidthRamp_962 {

    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5, 56, 86, 4, 3}));
        System.out.println(maxWidthRamp2(new int[]{2, 2, 1}));
    }

    /**
     * 暴力
     *
     * @param A
     * @return
     */
    public static int maxWidthRamp(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i < j && A[i] <= A[j]) {
                    if (max < (j - i)) {
                        max = j - i;
                    }
                }
            }
        }
        return max;
    }


    /**
     * 排序
     *
     * @param A
     * @return
     */
    public static int maxWidthRamp2(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < A.length; i++) {
            B[i] = i;
        }
        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i : B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }
}
