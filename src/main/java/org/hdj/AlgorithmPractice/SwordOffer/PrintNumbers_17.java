package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/8/3 下午10:50
 * @description: <pre>
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]  10-1
 *      n = 2   99  100-1
 *      n = 3   999  1000-1
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * </pre>
 */
public class PrintNumbers_17 {

    public static int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        //计算数组长度
        int pow = Double.valueOf(Math.pow(10, n)).intValue()-1;
        int[] result = new int[pow];
        for (int i = 0; i < pow; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = printNumbers(8);
    }
}
