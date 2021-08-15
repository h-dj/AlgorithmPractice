package org.hdj.AlgorithmPractice.LeetCode.algorithm;

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
        String s = "c";
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
     * 动态规划，判断s是否是t 的子串
     * <p>
     * 状态： f[i][j] 字符串t中　字符x在字符串t中的位置
     * 状态转移方程:
     * 0 <= i <= t.length()
     * 0 <= j < 26
     * f[i][j] = t.length()   i == t.length
     * f[i][j] = i            t.charAt(i) == j - 'a'
     * f[i][j] = f[i+1][j]    t.charAt(i) != j - 'a'
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence3(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        int sLen = s.length(), tLen = t.length();
        //记录每个字母在字符串t出现的下标位置
        int[][] f = new int[tLen + 1][26];
        //初始化数组
        for (int i = 0; i < 26; i++) {
            f[tLen][i] = tLen;
        }

        for (int i = tLen - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                //如果字符j - 'a'在字符串t中出现，则记录出现的下标
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                } else {
                    //否则记录上一次字符出现的位置下标
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        int aa = 0;
        //从记录好的表中查询s 是否是t的子串
        for (int i = 0; i < sLen; i++) {
            //获取字符
            char c = s.charAt(i);
            //得到26个字符中的那个
            int cIndex = c - 'a';
            //获取该字符是否存在t中
            int temp = f[aa][cIndex];
            //等于t的长度，则不存在
            if (temp == tLen) {
                return false;
            }
            //t字符串下一个字符
            aa = temp + 1;
        }
        return true;
    }
}
