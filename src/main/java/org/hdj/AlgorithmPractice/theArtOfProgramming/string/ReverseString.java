package org.hdj.AlgorithmPractice.theArtOfProgramming.string;

/**
 * @Description:
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，使得原字符串变成字符串“cdefab”。
 * 请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * @Author huangjiajian
 * @Date 2022/2/23 下午11:05
 */
public class ReverseString {

    /**
     * 暴力循环
     * @param s
     * @param n
     * @return
     */
    public String reverse(String s,int n){
        char[] chars = s.toCharArray();


        return "";
    }

    public static void main(String[] args) {
        //&	与	两个位都为1时，结果才为1
        //|	或	两个位都为0时，结果才为0
        // 0000 0001
        //
        int a = 4;
        int b = 1;
        int c = 1 << a;
        int d = 0 | c;
        int e = 0 & c;
        System.out.println('Z' - 'A');
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
