package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/8/10 下午4:34
 * @description: <pre>
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。
 * 因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 * </pre>
 */
public class HammingWeight_15 {

    /**
     * (n−1) 解析： 二进制数字 nn 最右边的 11 变成 00 ，此 11 右边的 00 都变成 11 。
     * n&(n−1) 解析： 二进制数字 nn 最右边的 11 变成 00 ，其余不变。
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

    public static int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    public static int hammingWeight3(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }

    /**
     * & 运算
     * 1 & 1 = 1
     * 1 & 0 = 0
     * 0 & 0 = 0
     *
     * @param n
     * @return
     */
    public static int hammingWeight4(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(hammingWeight(00000000000000000000000000001011));
        System.out.println(hammingWeight2(00000000000000000000000000001011));
        System.out.println(hammingWeight3(00000000000000000000000000001011));
        System.out.println(hammingWeight4(00000000000000000000000000001011));
    }
}
