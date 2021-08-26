package org.hdj.AlgorithmPractice.LeetCode.algorithm.array;

import java.util.Arrays;

/**
 * @Description: 合并区间
 *
 * <pre>
 *     思路
 *     1. 排序
 *     2. 再进行区间合并
 *
 * https://leetcode-cn.com/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
 * </pre>
 * @Author huangjiajian
 * @Date 2021/8/14 下午6:32
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        int len, count;
        count = len = intervals.length;

        //按照intervals[i][0] 值排序 一维数组
        quickSort(intervals, 0, intervals.length - 1);

        //如果 intervals[i][1] > intervals[i+1][0] 则重叠
        for (int i = 1; i < len; i++) {
            if (intervals[i - 1][1] >= intervals[i][0]) {
                if (intervals[i][0] > intervals[i - 1][0]) {
                    intervals[i][0] = intervals[i - 1][0];
                }
                if (intervals[i - 1][1] > intervals[i][1]) {
                    intervals[i][1] = intervals[i - 1][1];
                }
                intervals[i - 1][0] = -1;
                intervals[i - 1][1] = -1;
                count--;
            }
        }
        int[][] intervalsTemp = new int[count][2];
        for (int i = 0, j = 0; i < len; i++) {
            if (intervals[i][0] != -1) {
                intervalsTemp[j][0] = intervals[i][0];
                intervalsTemp[j][1] = intervals[i][1];
                j++;
            }
        }
        return intervalsTemp;
    }


    /**
     * 快排
     *
     * @param elements
     * @param start
     * @param end
     */
    public static void quickSort(int[][] elements, int start, int end) {
        int i = start, j = end;
        if (i >= j) {
            return;
        }
        int pivot = elements[i][0];
        //从表的两端向中间扫描
        while (i < j) {
            while (i < j && pivot <= elements[j][0]) {
                j--;
            }

            //交换位置
            if (i < j) {
                for (int idx = 0; idx < 2; idx++) {
                    int tmp = elements[i][idx];
                    elements[i][idx] = elements[j][idx];
                    elements[j][idx] = tmp;
                }
                i++;
            }


            while (i < j && pivot > elements[i][0]) {
                i++;
            }

            //交换位置
            if (i < j) {
                for (int idx = 0; idx < 2; idx++) {
                    int tmp = elements[j][idx];
                    elements[j][idx] = elements[i][idx];
                    elements[i][idx] = tmp;
                }
                j--;
            }
        }
        // 低子表排序
        quickSort(elements, start, i - 1);
        //高子表排序
        quickSort(elements, i + 1, end);
    }

    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{1, 3}, {2, 6}, {4, 8}});
//        merge = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
//        merge = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        merge = new int[][]{{1, 4}, {4, 5}};
//        merge = new int[][]{{1, 4}, {0, 0}};
        merge = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        merge = merge(merge);


        for (int i = 0; i < merge.length; i++) {
            for (int i1 = 0; i1 < merge[i].length; i1++) {
                System.out.print(merge[i][i1] + " ");
            }
            System.out.println();
        }

    }
}
