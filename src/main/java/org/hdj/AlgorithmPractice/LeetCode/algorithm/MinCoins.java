package org.hdj.AlgorithmPractice.LeetCode.algorithm;

import java.util.Arrays;

/**
 * @Description: 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author huangjiajian
 * @Date 2022/5/5 15:43
 */
public class MinCoins {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins,11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount <= 0) return -1;
        return coindp(coins, amount);
    }

    //状态：金额
    //转移：一个硬币，这个硬币的金额在coins[]数组中遍历
    //dp函数：输入金额，返回最少硬币数
    public static int coindp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//最多的硬币情况是全部是1元，共有amount个硬币，共有amount+1个状态，amount+1个金额
        Arrays.fill(dp, amount + 1);//必须将所有的dp赋最大值，因为要找最小值
        dp[0] = 0;//自底向上，金额为0，最小硬币数为0
        for (int am = 1; am <= amount; am++) {//自底向上
            for (int coin : coins) {//遍历coins的金额
                if (am >= coin)//am-coin 必须大于0，否则数组溢出
                    dp[am] = Math.min(dp[am], dp[am - coin] + 1);//金额为11的最小硬币数 和 金额为(11-一个面值)的最小硬币数+1 比较最小值
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];//返回金额为amount的最小硬币数 根据测试用例判断dp[amount]>amount
    }
}
