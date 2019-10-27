package org.hdj.AlgorithmPractice.SwordOffer;

import java.math.BigInteger;

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
     *时间复杂度O(2^n)
     * @param n
     * @return
     */
    public static int fibonacci_recursive(int n) {
        if(n <= 0){
            return 0;
        }
        if(n <=1){
            return 1;
        }
        return fibonacci_recursive(n-1) + fibonacci_recursive(n-2);
    }


    /**
     * 采用循环方式，叠加(保存前一个计算的结果)
     *
     * 时间复杂度O(n)
     * @param n
     * @return
     */
    public static BigInteger fibonacci_cycle(int n){
        BigInteger fn1 = new BigInteger("0");
        BigInteger fn2= new BigInteger("1");
        if(n <=0){
            return fn1;
        }
        if(n<=1){
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
     *|f(n)  f(n-1) |      | 1  1  |^n-1
     *|             | =    |       |
     *|f(n-1) f(n-2)|      | 1  0  |
     *
     *
     * 需要认识的概念:
     * 1. 矩阵
     * 2. 矩阵的乘法
     *
     * http://ruanyifeng.com/blog/2015/09/matrix-multiplication.html
     *
     * TODO 仍需了解
     */
    public static int fibonacci_formula(int n){

        return 0;
    }



    public static void main(String[] args) {
        int fibonacci = fibonacci_recursive(10);
        System.out.println(fibonacci);


        BigInteger fibonacci_cycle = fibonacci_cycle(10);
        System.out.println(fibonacci_cycle.toString());
    }
}
