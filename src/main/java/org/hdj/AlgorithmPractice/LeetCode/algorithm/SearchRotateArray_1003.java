package org.hdj.AlgorithmPractice.LeetCode.algorithm;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/7/20 下午10:27
 * @description: 面试题 10.03. 搜索旋转数组
 * <p>
 * <p>
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * 示例2:
 * <p>
 * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * 输出：-1 （没有找到）
 * 提示:
 * <p>
 * arr 长度范围在[1, 1000000]之间
 */
public class SearchRotateArray_1003 {

    public static void main(String[] args) {
        int[] arr = {15,4,5, 20, 25, 1, 3, 16, 19,10};
        System.out.println(search_1(arr, 5));

        System.out.println(search_2(arr, 5));
    }


    /**
     * 暴力美学
     *
     * @param arr
     * @return
     */
    public static int search_1(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * https://leetcode-cn.com/problems/search-rotate-array-lcci/solution/er-fen-fa-by-armeria-program/
     *
     * @param arr
     * @param target
     * @return
     */
    public static int search_2(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start >> 1);

            if (arr[mid] >= arr[start]) {
                if (arr[start] <= target && arr[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < arr[start]) {
                if (arr[start] <= target || arr[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] == arr[start]) {
                if (arr[start] != target) {
                    start++;
                } else {
                    return start;
                }
            }
        }
        return -1;
    }
}
