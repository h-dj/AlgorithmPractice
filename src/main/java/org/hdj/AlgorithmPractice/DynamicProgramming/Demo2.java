package org.hdj.AlgorithmPractice.DynamicProgramming;

import java.util.Scanner;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Demo2
 * @Package org.hdj.AlgorithmPractice.DynamicProgramming
 * @Description: 最大字段问题
 * 问题描述：
 * 给定由n个整数（可能有负数）组成的序列，求一段连续的子序列，要求该序列和最大，并求出最大值。
 * @date 2018/5/13 10:42
 */
public class Demo2 {

    public static void main(String[] args) {
        //// TODO: 2018/5/13
        int[] arr = new int[]{-2, 11, -4, 13, -5, -2};

        //getMaxSubArr(arr);
        // getMaxSubArr2(arr);
        // getMaxSubArr3(arr);
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] temp = new int[len];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = scanner.nextInt();
        }
        getMaxSubArr3(temp);

    }


    /**
     * 枚举
     *
     * @param a
     */
    public static void getMaxSubArr(int[] a) {
        int n = a.length - 1;
        long max = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum += a[k];

                max = Max(max, sum);
            }
        }
        System.out.println(String.format("最大子序列：%d ", max));
    }

    /**
     * 查找运算结合
     *
     * @param a
     */
    public static void getMaxSubArr2(int[] a) {
        int n = a.length - 1;
        long max = -1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;

            for (int j = i; j <= n; j++) {
                sum += a[j];
                max = Max(max, sum);
            }
        }
        System.out.println(String.format("最大子序列2：%d ", max));
    }

    /**
     * @param a
     */
    public static void getMaxSubArr3(int[] a) {
        //  子序列开始求和下标
        int start = 0;
        //  子序列结束求和下标
        int end = 1;
        //  记录子序列每一步求和的数组
        long[] dp = new long[a.length];
        dp[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            /**
             * 如数组：-2, 11, -4, 13, -5, -2
             * dp[i-1] = -2
             * a[i] = 11
             * if  dp[i - 1] + a[i] = 9 < a[i]=11
             *      则 dp[i] = a[i]
             *      重新开始序列的求和
             *      start = i
             * if   当前求和的值dp[i] > 最大求和值dp[end]
             *      则 end = i ; 当前求和值 为最大求和值
             */
            dp[i] = Max(dp[i - 1] + a[i], a[i]);
            if (dp[i] == a[i])
                start = i;
            if (dp[i] > dp[end])
                end = i;

        }





//        System.out.println(String.format("最大子序列：%s, 和为：%d",
//                Arrays.toString(Arrays.copyOfRange(a, start, end + 1)), dp[end]));
        System.out.println(dp[end]);
    }

    public static long Max(long a, long b) {
        return Math.max(a, b);
    }


}
