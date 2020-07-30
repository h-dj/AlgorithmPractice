package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/7/30 下午10:46
 * @description: 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 */
public class ReplaceSpace_05 {

    public static void main(String[] args) {
        System.out.println(replaceSpace(" 56  66 "));
        System.out.println(replaceSpace2(" 56  66 "));
    }


    /**
     * 使用正则
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        return s.replaceAll(" ", "%20");
    }

    /**
     * @param s
     * @return
     */
    public static String replaceSpace2(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        //找出s中的所有空格
        int spaceNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        char[] chars = new char[s.length() + spaceNum * 2];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            } else {
                chars[index++] = c;
            }
        }
        return new String(chars);
    }
}
