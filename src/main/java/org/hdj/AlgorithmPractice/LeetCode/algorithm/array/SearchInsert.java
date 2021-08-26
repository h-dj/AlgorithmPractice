package org.hdj.AlgorithmPractice.LeetCode.algorithm.array;

/**
 * @Description: 二分查找 搜索插入位置
 * @Author huangjiajian
 * @Date 2021/8/14 下午3:29
 */
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        int startIndex = 0, endIndex = nums.length - 1,middleIndex;
        while (startIndex <= endIndex) {
            middleIndex = (endIndex + startIndex) / 2;

            if (nums[middleIndex] > target) {
                endIndex = middleIndex - 1;
            } else if (nums[middleIndex] < target) {
                startIndex = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }
        return startIndex;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(searchInsert(new int[]{1}, 0));
        System.out.println(searchInsert(new int[]{1,3}, 3));
    }
}
