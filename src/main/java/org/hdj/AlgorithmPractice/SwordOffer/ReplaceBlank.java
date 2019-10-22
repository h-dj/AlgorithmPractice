package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 10/22/19 11:56 AM
 * @description: 替换空格为　%20
 * 把字符串中的空格替换为%20 , 如 We are Happy.  => We%20are%20Happy.
 * <p>
 * 解法：
 * 如果可以利用JDK　String API
 * 方法1：　s.replaceAll("\\s", "%20");
 * <p>
 * 方法2：两种模式
 * 1.　从前往后进行复制替换，会造成多次元素移动(扩容)
 * 2.　从后往前进行复制替换，这种需要先知道所有的空格数，计算出新的字符数组长度
 */
public class ReplaceBlank {


    /**
     * 替换空格
     *
     * @param str
     * @return
     */
    public static String replaceSpaces(StringBuffer str) {

        //检查参数
        if (str == null) {
            return null;
        }
        int length = str.length();

        //先统计空格数
        int newLength = length;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (' ' == c) {
                newLength += 2;
            }
        }
        if (newLength == length) {
            return str.toString();
        }
        char[] newChars = new char[newLength];

        int pos = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            char tempChar = str.charAt(i);
            if (' ' == tempChar) {
                newChars[pos--] = '0';
                newChars[pos--] = '2';
                newChars[pos--] = '%';
            } else {
                newChars[pos--] = tempChar;
            }
        }

        return new String(newChars);
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer(" We        are Happy. ");
        String s = replaceSpaces(str);
        System.out.println(s);
        System.out.println(s.length());
    }
}
