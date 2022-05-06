package org.hdj.AlgorithmPractice.practice;

/**
 * @Description: 链接：https://www.nowcoder.com/questionTerminal/3d08b635346d4610b01c6256bc07c394
 * 来源：牛客网
 * <p>
 * 小A很喜欢字母N，他认为连续的N串是他的幸运串。有一天小A看到了一个全部由大写字母组成的字符串，他被允许改变最多2个大写字母（也允许不改变或者只改变1个大写字母），使得字符串中所包含的最长的连续的N串的长度最长。你能帮助他吗？
 * <p>
 * <p>
 * 输入描述:
 * 输入的第一行是一个正整数T（0 < T <= 20），表示有T组测试数据。对于每一个测试数据包含一行大写字符串S（0 < |S| <= 50000，|S|表示字符串长度）。
 * <p>
 * 数据范围：
 * <p>
 * 20%的数据中，字符串长度不超过100；
 * <p>
 * 70%的数据中，字符串长度不超过1000；
 * <p>
 * 100%的数据中，字符串长度不超过50000。
 * <p>
 * <p>
 * 输出描述:
 * 对于每一组测试样例，输出一个整数，表示操作后包含的最长的连续N串的长度。
 * 示例1
 * 输入
 * 3
 * NNTN
 * NNNNGGNNNN
 * NGNNNNGNNNNNNNNSNNNN
 * 输出
 * 4
 * 10
 * 18
 * @Author huangjiajian
 * @Date 2022/5/6 9:16
 */
public class LuckCharN {

    public static void main(String[] args) {
        String s = "NNTN";

        String s1 = "NNNNGGNNNN";
        String s2 = "NGNNNNGNNNNNNNNSNNNN";

        System.out.println(sliding_window(s));
        System.out.println(sliding_window(s1));
        System.out.println(sliding_window(s2));
    }


    /**
     * 滑动窗口
     *
     * @return
     */
    public static int sliding_window(String luckCharN) {
        if (luckCharN == null || luckCharN.length() == 0) {
            return 0;
        }
        //滑动窗口左右边界
        int right = 0;
        int left = 0;
        //最长 N字符
        int max = 0;
        //不是 字符N的个数
        int notN = 0;
        char[] chars = luckCharN.toCharArray();
        int len = chars.length;

        while (right < len) {

            if (chars[right++] != 'N') {
                //右边界如果不是 N，记录个数
                notN++;
            }

            //个数超过两个
            while (notN > 2) {
                //滑动窗口左边界移动
                if (chars[left++] != 'N') {
                    notN--;
                }
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
