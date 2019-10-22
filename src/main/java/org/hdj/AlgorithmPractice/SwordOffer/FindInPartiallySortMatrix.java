package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 10/21/19 1:46 PM
 * @description:　 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInPartiallySortMatrix {


    /**
     * 从有序矩阵中找是否存在某数字
     *
     * @param matrix
     * @param row
     * @param column
     * @param number
     * @return
     */
    public static boolean find(int[][] matrix, int row, int column, int number) {
        //检查参数
        if (matrix == null || row < 0 || column < 0) {
            return false;
        }

        if (matrix.length < row || matrix[0].length < column) {
            return false;
        }

        int i = 0, j = column - 1;
        while (i < row && j > 0) {
            if (matrix[i][j] > number) {
                j--;
            } else if (matrix[i][j] < number) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int[][] matrix = {};
        int row = 5;
        int column = 8;
        boolean b = find(matrix, row, column, 7);
        System.out.println(b);
    }
}
