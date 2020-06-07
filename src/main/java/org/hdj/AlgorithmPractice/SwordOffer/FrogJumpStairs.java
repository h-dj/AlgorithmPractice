package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 07/06/2020 17:10
 * @description:青蛙跳台阶（斐波那契数列） 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class FrogJumpStairs {

    /**
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }

        int sum = 0;
        int one = 0;
        int two = 1;
        for (int i = 1; i <=n; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = numWays(3);
        System.out.println(i);
    }
}
