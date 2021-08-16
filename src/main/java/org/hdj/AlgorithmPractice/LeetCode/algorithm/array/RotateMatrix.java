package org.hdj.AlgorithmPractice.LeetCode.algorithm.array;

/**
 * @Description: 旋转矩阵 90度
 * <p>
 * 思路
 * 1. 先倒置二维数组
 * 2. 在行转列
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
 * @Author huangjiajian
 * @Date 2021/8/16 上午11:08
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        //先倒置二维数组
        int start = 0, end = matrix.length - 1, len = end,temp;
        while (start < end) {
            for (int i = 0; i <= len; i++) {
                temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
            }
            start++;
            end--;
        }

        //再行转列
        for (int i = 0; i <= len; i++) {
            for (int i1 = i; i1 <= len; i1++) {
                temp = matrix[i][i1];
                matrix[i][i1] = matrix[i1][i];
                matrix[i1][i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                System.out.print(matrix[i][i1]);
            }
            System.out.println();
        }

    }
}
