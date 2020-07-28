package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/7/28 下午2:34
 * @description: 左转字符串
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 1 <= k < s.length <= 10000
 */
public class ReverseLeftWords_58 {


    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
        System.out.println(reverseLeftWords2("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int length = s.length();
        char[] src = s.toCharArray();
        char[] temp = new char[length];
        System.arraycopy(src, n, temp, 0, length - n);
        System.arraycopy(src, 0, temp, length - n, n);
        return new String(temp);
    }

    public static String reverseLeftWords2(String s, int n) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }
}
