package org.hdj.AlgorithmPractice.LeetCode.algorithm;

/**
 * @author hdj
 * @version 1.0
 * @date 08/06/2020 23:15
 * @description: 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 */
public class DivisorGame_1025 {


    public static void main(String[] args) {
        boolean b = divisorGame(100);
        System.out.println(b);

        System.out.println(divisorGame2(100));

        System.out.println(divisorGame3(100));
    }


    /**
     * 动态规划思想解法
     * <p>
     * 状态: dp[i]存的是操作数为i时的玩家的获胜情况,  dp[i-x] 为对手输的情况
     * 状态转移方程: dp[i] = i % x == 0 && !dp[i-x]
     * 边界:  dp[1] = false; dp[2] = true;
     *
     * @param N
     * @return
     */
    public static boolean divisorGame3(int N) {

        if (N == 1) {
            return false;
        }
        //保存玩家获胜情况
        boolean[] dp = new boolean[N + 1];
        //初始化dp数组(边界)
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i <=N; i++) {
            //先置dp[i]为false，符合条件则置true
            dp[i] = false;


            //玩家都以最佳状态，即玩家操作i后的操作数i-x应尽可能使对手输，即dp[i-x]应尽可能为false
            //所以遍历x=1~i-1,寻找x的约数，使得dp[i-x]=false，那么dp[i]=true即当前操作数为i的玩家能获胜
            //如果找不到则为false，会输掉
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }


    /**
     * 奇数偶数思想解法
     * https://leetcode-cn.com/u/vegetablebird/
     * 如果N是奇数，因为奇数的所有因数都是奇数，因此 N 进行一次 N-x 的操作结果一定是偶数，
     * 所以如果 a 拿到了一个奇数，那么轮到 b 的时候，b拿到的肯定是偶数，这个时候 b 只要进行 -1，
     * 还给 a 一个奇数，那么这样子b就会一直拿到偶数，到最后b一定会拿到最小偶数2，a就输了。
     * <p>
     * 所以如果游戏开始时Alice拿到N为奇数，那么她必输，也就是false。
     * 如果拿到N为偶数，她只用 -1，让bob 拿到奇数，最后bob必输，结果就是true。
     *
     * @param N
     * @return
     */
    public static boolean divisorGame2(int N) {
//        return (N % 2) == 0;
        return (N & 1) == 0;
    }


    /**
     * 暴力枚举
     *
     * @param N
     * @return
     */
    public static boolean divisorGame(int N) {
        return divisorGame(N, 0);
    }

    private static boolean divisorGame(int N, int i) {
        int x = 1;
        //找出x
        while (x < N) {
            if (N % x == 0) {
                break;
            }
            x++;
        }
        if (x >= N) {
            return i == 0 ? false : true;
        }
        N = N - x;
        if (i == 0) {
            return divisorGame(N, 1);
        } else {
            return divisorGame(N, 0);
        }
    }
}
