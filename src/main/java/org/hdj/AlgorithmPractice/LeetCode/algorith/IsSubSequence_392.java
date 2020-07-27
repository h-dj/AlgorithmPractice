package org.hdj.AlgorithmPractice.LeetCode.algorith;

import java.util.Arrays;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/7/27 上午11:59
 * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 后续挑战 :
 * <p>
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * <p>
 * 答案查阅
 * https://leetcode-cn.com/problems/is-subsequence/solution/javade-2chong-jie-fa-by-sdwwld/
 */
public class IsSubSequence_392 {


    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        System.out.println(isSubsequence_indexOf(s, t));
        System.out.println(isSubsequence2(s, t));
        System.out.println(isSubsequence3(s, t));
    }

    /**
     * 逐个查找
     * 1. 考虑空字符串情况
     * 2. 子串字符顺序不变
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int flag = 0;
        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();

        int j = 0;
        for (int i = 0; i < sArr.length; i++) {
            for (; j < tArr.length; j++) {
                if (tArr[j] == sArr[i]) {
                    flag++;
                    j++;
                    if (flag == sArr.length) {
                        return true;
                    }
                    break;
                } else if (sArr.length == tArr.length) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 逐个查找
     * 1. 考虑空字符串情况
     * 2. 子串字符顺序不变
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence_indexOf(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针
     * 时间复杂度：O(n+m)　??
     * 空间复杂度：O(1)
     */
    public static boolean isSubsequence2(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        int sLen = s.length(), tLen = t.length();
        int i = 0, j = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                //匹配成功，进行下一个字符
                i++;
            }
            j++;
        }
        return i == sLen;

    }

    /**
     * 动态规划
     * 状态:
     * 令 f[i][j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置。
     * 状态转移方程：
     * f[i][j] = i,  t[i] = j
     * f[i][j] = f[i+1][j],  t[i] != j
     */
    public static boolean isSubsequence3(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int n = s.length(), m = t.length();
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }
        Arrays.stream(f)
                .forEach(ints -> System.out.println(Arrays.toString(ints)));
        System.out.println();
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];

                Arrays.stream(f)
                        .forEach(ints -> System.out.println(Arrays.toString(ints)));
                System.out.println();
            }
        }
        Arrays.stream(f)
                .forEach(ints -> System.out.println(Arrays.toString(ints)));

        int add = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int ca = c - 'a';
            int temp = f[add][ca];

            if (temp == m) {
                return false;
            }
            add = temp + 1;
        }
        return true;
    }
}
