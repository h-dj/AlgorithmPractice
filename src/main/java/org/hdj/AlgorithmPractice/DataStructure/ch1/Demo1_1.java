package org.hdj.AlgorithmPractice.DataStructure.ch1;

/**
 * 算法设计举例
 * <p>
 * 最大子序列和问题，不同算法实现和复杂度分析
 */
public class Demo1_1 {

    private static int[] sequences = {-2, 11, -4, 13, -5, 2, -5, -3, 12, -9};


    /**
     * 暴力方法，穷举
     * <p>
     * 第一层循环执行一次，计算出长度为i的所有子序列和的最大值
     * <p>
     * 时间复杂度： sum(i)*(n-i+1)  1<i<=n  = O(n^3)
     *
     * @param sequence
     */
    public static void maxSub_1(int[] sequence) {
        int max = 0;
        int n = sequence.length;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                sum = 0;
                for (int k = j; k < j + i && k < n; k++) {

                    sum += sequence[k];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }


    /**
     * 方法二
     * 合并步骤
     * <p>
     * 时间复杂度： sum(n-i) = n*(n+1)/2 = O(n^2)  0<i <n
     *
     * @param sequence
     */
    public static void maxSub_2(int[] sequence) {
        int max = 0;
        int n = sequence.length;
        int sum = 0;

        for (int i = 0; i <= n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += sequence[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }

    /**
     * 分治法
     * -2, 11, -4, 13, -5, 2, -5, -3, 12, -9
     *
     * @param sequence
     */
    public static int maxSub_3(int[] sequence, int left, int right) {

        //判断左右下标，是否相同
        if (left == right) {
            if (sequence[left] > 0) {
                return sequence[left];
            } else {
                return 0;
            }
        }
        int mid = (left + right) / 2;

        int maxLeftSum = maxSub_3(sequence, left, mid);

        int maxRightSum = maxSub_3(sequence, mid + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;

        for (int i = mid; i >= left; i--) {
            leftBorderSum += sequence[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }
        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            rightBorderSum += sequence[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int a, int b, int c) {
        int max = a > b ? a : b;
        max = max > c ? max : c;
        return max;
    }


    /**
     * 动态规划
     *
     * @param sequences
     * @return
     */
    public static int maxSum_4(int[] sequences) {
        int max = 0;
        int n = sequences.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sequences[i];
            if (sum > max) {
                max = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = maxSub_3(sequences, 0, sequences.length - 1);
        System.out.println(i);
    }

}
