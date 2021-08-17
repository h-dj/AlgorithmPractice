package org.hdj.AlgorithmPractice.LeetCode.algorithm.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 零矩阵
 * <p>
 * 思路
 * 1. 用两个标记数组分别记录每一行和每一列是否有零出现
 * 2. 在把有零出现的行列置零
 * https://leetcode-cn.com/problems/zero-matrix-lcci/solution/ling-ju-zhen-by-leetcode-solution-7ogg/
 * @Author huangjiajian
 * @Date 2021/8/17 下午10:02
 */
public class SetZeroes {

    public static void setZeroes(int[][] matrix) {
        Boolean[] rowIndex = new Boolean[matrix.length];
        Boolean[] colIndex = new Boolean[matrix[0].length];

        //记录需要置零的点
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                if (matrix[i][i1] == 0) {
                    rowIndex[i] = true;
                    colIndex[i1] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (Boolean.TRUE.equals(rowIndex[i]) || Boolean.TRUE.equals(colIndex[j])) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;

        //判断第一列是否有零
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }

            for (int i1 = 1; i1 < n; i1++) {
                if (matrix[i][i1] == 0) {
                    //在遍历第一行时，把第一行是否有零存入第一个行第一个元素 matrix[0][0] i = 0
                    matrix[i][0] = matrix[0][i1] = 0;
                }
            }
        }

        //置零
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            //第一列是否需要置零
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                System.out.print(matrix[i][i1] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{2, 3}, {4, 5}, {6, 0}, {8, 9}, {1, 10}};
        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        print(matrix);

        setZeroes2(matrix);

        print(matrix);
    }
}
