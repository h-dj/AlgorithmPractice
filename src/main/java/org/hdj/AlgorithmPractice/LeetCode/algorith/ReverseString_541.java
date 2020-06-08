package org.hdj.AlgorithmPractice.LeetCode.algorith;

/**
 * @author hdj
 * @version 1.0
 * @date 6/8/20 11:55 AM
 * @description: 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class ReverseString_541 {

    public static String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder(chars.length);
        int start = 0;
        int end = k;
        for (int i = 0; i < chars.length; ) {
            if (end > chars.length) {
                end = chars.length;
            }
            if (i == start) {
                for (int i1 = end - 1; i1 >= start; --i1) {
                    builder.append(chars[i1]);
                }
                start += 2 * k;
                end = start + k;
                i += k;
            } else {
                builder.append(chars[i]);
                i++;
            }

        }
        return builder.toString();
    }

    public static String reverseStr2(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; ) {
            if (i == start) {
                int startIndex = start;
                int endIndex = startIndex + k - 1;

                if (endIndex > chars.length-1) {
                    endIndex = chars.length-1;
                }
                while (startIndex < endIndex) {
                    char temp = chars[endIndex];
                    chars[endIndex] = chars[startIndex];
                    chars[startIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                start += 2 * k;
                i += k;
            } else {
                i++;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = reverseStr2("abcdefg", 2);
        System.out.println(str);
    }
}
