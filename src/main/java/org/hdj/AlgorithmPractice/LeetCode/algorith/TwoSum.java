package org.hdj.AlgorithmPractice.LeetCode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hdj
 * @version 1.0
 * @date 2019/9/24 23:15
 * @description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    private static int[] nums = {2, 7, 11, 15};
    private static int target = 9;

    public static void main(String[] args) {
        int[] ints = twoSum1(nums, target);

        ints = twoSum2(nums, target);
        System.out.println(Arrays.toString(ints));
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
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[j] == nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException();
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
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

}
