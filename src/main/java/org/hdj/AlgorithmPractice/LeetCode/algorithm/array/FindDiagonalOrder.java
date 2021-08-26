package org.hdj.AlgorithmPractice.LeetCode.algorithm.array;

import java.util.Arrays;

/**
 * @Description: 对角线遍历
 * <p>
 * https://leetcode-cn.com/problems/diagonal-traverse/solution/jian-dan-yi-dong-by-renx-5-cpu9/
 * @Author huangjiajian
 * @Date 2021/8/18 下午8:49
 */
public class FindDiagonalOrder {

    public static int[] findDiagonalOrder(int[][] mat) {
        //判断是否为空
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;
        int[] ret = new int[m * n];
        int i = 0, j = 0;
        int fx = 1; //1为右上，-1为左下
        for (int cur = 0; cur < ret.length; cur++) {
            ret[cur] = mat[i][j];
            //在右边界，需要往下对角线遍历
            if (j == n - 1 && fx == 1) {
                fx = -1;
                i = i + 1;
                continue;
            }

            //下边界，需要往上对角线遍历
            if (i == m - 1 && fx == -1) {
                fx = 1;
                j = j + 1;
                continue;
            }
            //上边界，需要往下对角线遍历
            if (i == 0 && fx == 1) {
                fx = -1;
                j = j + 1;
                continue;
            }

            //左边界，需要往上对角线遍历
            if (j == 0 && fx == -1) {
                fx = 1;
                i = i + 1;
                continue;
            }
            //如果不在边界则按遍历的方向fx，变化i和j ,这里妙啊
            i = i - fx;
            j = j + fx;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] diagonalOrder = findDiagonalOrder(mat);
        System.out.println(Arrays.toString(diagonalOrder));

    }
}
