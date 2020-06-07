package org.hdj.AlgorithmPractice.SwordOffer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author hdj
 * @version 1.0
 * @date 10/21/23 2:03 PM
 * @description:　 <br/>
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci {

    /**
     * 递归（存在重复计算）
     * 时间复杂度O(2^n)
     *
     * @param n
     * @return
     */
    public static int fibonacci_recursive(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
    }


    /**
     * 采用循环方式，叠加(保存前一个计算的结果)
     * <p>
     * 时间复杂度O(n)
     *
     * @param n
     * @return
     */
    public static BigInteger fibonacci_cycle(int n) {
        BigInteger fn1 = new BigInteger("0");
        BigInteger fn2 = new BigInteger("1");
        if (n <= 0) {
            return fn1;
        }
        if (n <= 1) {
            return fn2;
        }
        BigInteger sum = null;
        for (int i = 2; i <= n; ++i) {
            sum = fn1.add(fn2);//第三项开始等于前两项相加
            fn1 = fn2;
            fn2 = sum;//保存前两项的计算结果
        }
        return sum;
    }

    /**
     * 采用数学公式
     * |f(n)  f(n-1) |      | 1  1  |^n-1
     * |             | =    |       |
     * |f(n-1) f(n-2)|      | 1  0  |
     * <p>
     * <p>
     * 需要认识的概念:
     * 1. 矩阵
     * 2. 矩阵的乘法
     * <p>
     * 资料
     * http://ruanyifeng.com/blog/2015/09/matrix-multiplication.html
     * https://blog.csdn.net/zhengwei223/article/details/78758775
     */
    public static int fibonacci_formula(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        int[][] matrix = {
                {1, 1},
                {1, 0}
        };
        int[][] ints = matrixPower(matrix, n - 1);
        return ints[0][0];
    }

    /**
     * 矩阵乘法
     * 矩阵1为n*m矩阵，矩阵2为m*p矩阵
     * 结果为n*p矩阵
     */
    public static int[][] matrixMultiply(int[][] m1, int[][] m2) {
        final int n = m1.length;
        final int m = m1[0].length;
        final int p = m2[0].length;
        int[][] result = new int[n][p];// 新矩阵的行数为m1的行数，列数为m2的列数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return result;
    }

    /**
     * 求矩阵matrix的p次方
     *
     * @param matrix
     * @param p
     * @return
     */
    public static int[][] matrixPower(int[][] matrix, int p) {
        //初始化结果为单位矩阵，对角线为1
        int[][] result = new int[matrix.length][matrix[0].length];
        //单位矩阵，相当于整数的1
        for (int i = 0; i < result.length; i++) {
            result[i][i] = 1;
        }

        //平方数
        int[][] pingFang = matrix; // 一次方
        //p >>= 1 ; p像右移动1位，相当于除以二
        // a^4 = a^2 * a^2
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) { // 当前二进制位最低位为1，将当前平方数乘到结果中
                result = matrixMultiply(result, pingFang);
            }
            //平方数继续上翻
            pingFang = matrixMultiply(pingFang, pingFang);
        }
        return result;
    }

    public static void main(String[] args) {
//        int fibonacci = fibonacci_recursive(10);
//        System.out.println(fibonacci);
//
//
        BigInteger fibonacci_cycle = fibonacci_cycle(10);
        System.out.println(fibonacci_cycle.toString());

        int result = fibonacci_formula(10);
        System.out.println(result);
    }
}
