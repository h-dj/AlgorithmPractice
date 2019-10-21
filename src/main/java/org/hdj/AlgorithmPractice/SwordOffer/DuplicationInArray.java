package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 10/21/19 2:03 PM
 * @description:　 <pre>
 *      在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字是重复的。
 *      也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *      例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * </pre>
 * <p>
 * 解法一：
 * 1. 先排序，再遍历；相邻的两数字相同则重复
 * 2. 时间复杂度O(nlogn)
 * <p>
 * 解法二：
 * 1. 采用辅助HashMap 保存出现的数字, 在遍历数组时，如果Hashmap已包含该数字，则这数字重复
 * 2.　时间复杂度O(n)
 * 3. 空间复杂度O(n)
 * <p>
 * 解法三：
 * 注意点：　在一个长度为n的数组里的所有数字都在0到n-1的范围内，所以说数字也是数组中的下标范围内
 * 那么，在遍历的时候，我们把对应的数字放到对应的下标中，如果发现下标 i 对应的数值c和对应的下标c中的值b相等，则找到重复值
 * 时间复杂度: O(n)
 * 空间复杂度O(1)
 */
public class DuplicationInArray {


    /**
     * 这个算法改变了数组的顺序
     *
     * @param numbers     数组
     * @param length      　数组长度
     * @param duplication 　用于保存重复数字
     * @return
     */
    public static boolean findDuplication(int numbers[], int length, int[] duplication) {
        //检查参数是否合法
        if (numbers == null
                || duplication == null
                || length < 0
                || length > numbers.length) {
            return false;
        }

        for (int i = 0; i < length; i++) {

            //判断数组中的值是否合法
            if (numbers[i] < 0 || numbers[i] >= length) {
                return false;
            }

            //判断当前值是否于当前下标相等
            while (numbers[i] != i) {
                int c = numbers[i];

                //不相等，则判断当前值与下标为c 的值是否相等
                if (numbers[c] == c) {
                    //相等，则找到重复值
                    duplication[0] = c;
                    return true;
                }

                //否则，交换两数字的位置
                int temp = numbers[c];
                numbers[c] = c;
                numbers[i] = temp;
            }
        }

        return false;
    }
}
