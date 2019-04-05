package org.hdj.AlgorithmPractice.DynamicPrograming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Demo3
 * @Package org.hdj.AlgorithmPractice.DynamicPrograming
 * @Description: 最大公共子序列
 * @date 2018/5/20 20:18
 */
public class Demo3 {


    public static void main(String[] args) {
        //// TODO: 2018/5/20
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        char[] charA = str1.toCharArray();
        char[] charB = str2.toCharArray();

        int m = charA.length;
        int n = charB.length;

        String[][] result = new String[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = "0";
                } else {
                    if (charA[i - 1] == charB[j - 1]) {
                        int num = Integer.valueOf(result[i - 1][j - 1].replaceAll("[^\\d]", ""));
                        num += 1;
                        result[i][j] = "/" + num + charA[i - 1];
                    } else {
                        int left = Integer.valueOf(result[i][j - 1].replaceAll("[^\\d]", ""));
                        int top = Integer.valueOf(result[i - 1][j].replaceAll("[^\\d]", ""));
                        String path = left > top ? "——" : "|";
                        result[i][j] = path + Math.max(top, left);
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(result));
        StringBuffer buffer = new StringBuffer();
        for (int i = m; i > 0; ) {
            for (int j = n; j > 0; ) {
                System.out.println(result[i][j]);
                String path = result[i][j].replaceAll("[^/|——]", "");
                if ("/".equals(path)) {
                    String _char = result[i][j].replaceAll("[^a-zA-Z]", "");
                    buffer.append(_char);
                    i--;
                    j--;
                } else if ("|".equals(path)) {
                    i--;
                } else if ("——".equals(path)) {
                    j--;
                } else {
                    break;
                }
            }
        }
        System.out.println(buffer.reverse().toString());
        scanner.close();

    }

}
