package org.hdj.AlgorithmPractice.LeetCode.algorith;

import java.util.Arrays;

/**
 * @author hdj
 * @version 1.0
 * @date 07/06/2020 17:35
 * @description:<br/> 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * <p>
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1:
 * <p>
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 * <p>
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 * <p>
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 * <p>
 * <p>
 * <p>
 * 递归
 * 备忘录算法
 * 动态规划
 */
public class MinCostJumpStairs_746 {

    /**
     * 备忘录算法
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int fn1 = cost[0];
        int fn2 = cost[1];
        int fn = 0;
        for (int i = 2; i < cost.length; i++) {
            fn = cost[i] + Math.min(fn1, fn2);
            fn1 = fn2;
            fn2 = fn;
        }
        return fn;
    }

    /**
     * 动态规划
     * 一次可以爬一个阶梯或者爬两个阶梯
     * 所以，在爬楼梯前，要知道爬一个台阶的体力值大还是爬两个台阶的体力值大
     * 爬到n 阶时花费的体力值为f(n)
     * <p>
     * 最优子结构：f(n-1) + cost[n]  和  f(n-2) + cost[n]
     * 边界：f(0) = const[0] f(1) = const[1]
     * 状态转移方程: f(n) = Math.min(f(n-1),f(n-2)) + cost[n];
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs3(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        int i = minCostClimbingStairs3(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(i);
    }
}
