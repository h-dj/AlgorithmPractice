package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/8/4 上午9:08
 * @description:
 */
public class PrintNumbers_17 {


    /**
     * 不考虑大数情况
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        //计算数组长度
        int pow = Double.valueOf(Math.pow(10, n)).intValue() - 1;
        int[] result = new int[pow];
        for (int i = 0; i < pow; i++) {
            result[i] = i + 1;
        }
        return result;
    }


    public static void printNumbers2(int n) {
        StringBuilder str = new StringBuilder();
        // 将str初始化为n个'0'字符组成的字符串
        for (int i = 0; i < n; i++) {
            str.append('0');
        }
        while (!increment(str)) {
            // 去掉左侧的0
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0') {
                index++;
            }
            System.out.println(str.toString().substring(index));
        }
    }

    public static boolean increment(StringBuilder str) {
        boolean isOverflow = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            char s = (char) (str.charAt(i) + 1);
            // 如果s大于'9'则发生进位
            if (s > '9') {
                str.replace(i, i + 1, "0");
                if (i == 0) {
                    isOverflow = true;
                }
            }
            // 没发生进位则跳出for循环
            else {
                str.replace(i, i + 1, String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }

    public static void main(String[] args) {
        int[] ints = printNumbers(2);
        printNumbers2(2);
    }
}
