package org.hdj.AlgorithmPractice;

import java.util.Scanner;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Lcs
 * @Package org.hdj.AlgorithmPractice
 * @Description: 最长公共子序列Lcs
 * @date 2017/11/22 11:57
 */
public class Lcs {

    public int getLCS(String a, String b) {

        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        int lenA = charA.length;
        int lenB = charB.length;

        int n = lenA + 1;
        int m = lenB + 1;

        int[][] result = new int[n][m];
        int i, j;
//        for (i = 0; i < n; i++) result[i][0] = 0; //将第一列全部置零
//        for (j = 0; j < m; j++) result[0][j] = 0; //将第一行全部置零

        for (i = 1; i < n; i++)
            for (j = 1; j < m; j++) //逐行填充表格
            {
                //如果两个字符相等，则result[i][j]等于表中左上角元素值+1
                if (charA[i - 1] == charB[j - 1]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                    //如果两个字符不相等，则result[i][j]等于表中左边或者是上边元素值的最大者
                    //result[i][j-1]表示左边元素;result[j][i-1]表示s上边元素
                } else {
                    result[i][j] = getMax(result[i][j - 1], result[i - 1][j]);
                }
            }
        int returnNum = result[n - 1][m - 1];//最后返回的结果：最长公共子序列长度
        return returnNum;
    }

    private int getMax(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        Lcs lcs = new Lcs();
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(lcs.getLCS(str1, str2));

    }
}