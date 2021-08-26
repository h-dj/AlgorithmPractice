package org.hdj.AlgorithmPractice.LeetCode.algorithm.array;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2021/8/14 下午2:42
 */
public class PivotIndex {

    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int leftSum = 0, rightSum = 0;

        //右边累加
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        //中心下标为数组最左元素
        if (leftSum == rightSum) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            rightSum -= nums[i];
            leftSum += nums[i - 1];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println("pivotIndex =" + pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println("pivotIndex =" + pivotIndex(new int[]{1, 2, 3}));
        System.out.println("pivotIndex =" + pivotIndex(new int[]{2, 1, -1}));
    }
}
