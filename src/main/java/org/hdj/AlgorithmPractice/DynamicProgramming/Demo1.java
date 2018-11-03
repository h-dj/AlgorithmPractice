package org.hdj.AlgorithmPractice.DynamicProgramming;

import java.util.Scanner;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Demo1
 * @Package org.hdj.AlgorithmPractice.DynamicProgramming
 * @Description: 练习动态规划---矩阵取数问题
 * 题目
 * 一个N*N矩阵中有不同的正整数，经过这个格子，就能获得相应价值的奖励，
 * 从左上走到右下，只能向下向右走，求能够获得的最大价值。
 * 例如：3 * 3的方格。
 * <p>
 * 1 3 3
 * 2 1 3
 * 2 2 1
 * <p>
 * 能够获得的最大价值为：11。
 * @date 2018/5/12 22:41
 */
public class Demo1 {

    public static void main(String[] args) {
        //// TODO: 2018/5/12
        Scanner scanner = new Scanner(System.in);
        //  初始化矩阵大小N  : 2< N <500
        int N = scanner.nextInt();
        long[][] matrix = new long[N + 1][N + 1];
        for (int i = 1; i < matrix.length; i++) {
            for (int i1 = 1; i1 < matrix.length; i1++) {
                matrix[i][i1] = scanner.nextLong();
            }
        }



        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                long left = matrix[i][j - 1];
                long top = matrix[i - 1][j];
                long max = Math.max(left, top);
                matrix[i][j] = matrix[i][j] + max;
            }
        }

        System.out.println(matrix[N][N]);




        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
