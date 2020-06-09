package org.hdj.AlgorithmPractice.LeetCode.algorith;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hdj
 * @version 1.0
 * @date 6/9/20 12:08 PM
 * @description: 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class SumRangeArray_303 {

    public static void main(String[] args) {
        NumArray2 numArray2 = new NumArray2(new int[]{-2, 0, 3, -5, 2, -1});
        int i = numArray2.sumRange(2, 5);
        System.out.println(i);

        NumArray3 numArray3 = new NumArray3(new int[]{-2, 0, 3, -5, 2, -1});
        i = numArray3.sumRange(2, 5);
        System.out.println(i);
    }
}


/**
 * 暴力求和
 */
class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (i < 0) {
            i = 0;
        }
        if (j > nums.length - 1) {
            j = nums.length - 1;
        }
        int sum = 0;
        for (int i1 = i; i1 <= j; i1++) {
            sum += nums[i1];
        }
        return sum;
    }
}


/**
 * 使用缓存
 * 每一种情况都计算出来
 * 预运算时间复杂度O(n^2)
 */
class NumArray2 {

    private Map<String, Integer> cache;

    public NumArray2(int[] nums) {
        if (nums != null && nums.length > 0) {
            cache = new HashMap<>(nums.length, 1);

            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    cache.put(String.format("%d:%d", i, j), sum);
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        return cache.getOrDefault(String.format("%d:%d", i, j), 0);
    }
}

/**
 * 动态规划
 * 状态 dp[i] 前i项和
 * 状态转移 dp[i] = dp[i-1] + nums[i]
 * <p>
 * sum{i,j} = dp[j+1] -dp[i]  i项到j项和等于前j项和 - 前i项和,
 */
class NumArray3 {

    private int[] dp;

    public NumArray3(int[] nums) {
        if (nums != null && nums.length > 0) {
            dp = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                dp[i+1] = dp[i] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }
}