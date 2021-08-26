package org.hdj.AlgorithmPractice.LeetCode.algorithm;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjiajian
 * @Date 2021/8/26 14:54
 * @Description: 重复无序数组找出相加为target的所有对(两数之和 的变种)
 */
public class TwoSumAll {

    private static int[] nums = {2, 7, 11, 8, 15, 1, 6, 3};
    private static int target = 9;

    public static void main(String[] args) {
        int[] ints = twoSum2(nums, target);
        for(int i = 0; i < ints.length; i++) {
          System.out.print(ints[i]);
        }
        System.out.println();
    }

    /**
     * 暴力求解
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int index = 0;
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[j] == nums[i]) {
                    result[index++] = i;
                    result[index++] = j;
                }
            }
        }
        return result;
    }

    /**
     * 采用HashMap 优化
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int index = 0;
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                result[index++] = map.get(key);
                result[index++] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }


}
