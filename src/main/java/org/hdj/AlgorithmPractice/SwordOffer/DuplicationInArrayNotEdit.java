package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 10/21/19 2:03 PM
 * @description:　 <br/>
 * <pre>
 *   题目：在不修改数组找出重复的数字
 *   描述：在一个长度为n+1的数组里的所有数字都在1~n 的范围内，所以数组中至少有一个数字是重复的。
 *   请找出数组中任意一个重复的数字，但不能修改输入的数组。例如，如果输入长度为８的数组{2,3,5,4,3,2,6,7},
 *   那么对应的输出是重复的数字2或者3。
 * </pre>
 * <p>
 * 注意题目中的 长度n+1的数组里所有数字都在1~n范围内，
 * <p>
 */
public class DuplicationInArrayNotEdit {


    public static int getDuplication(int[] numbers, int length) {
        //检查参数
        if (numbers == null || length < 0 || length > numbers.length) {
            return -1;
        }

        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, length, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                }
                break;
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 计算在范围start~middle 中是否有重复数字
     *
     * @param numbers
     * @param length
     * @param start
     * @param end
     * @return
     */
    private static int countRange(int[] numbers, int length, int start, int end) {

        int count = 0;
        for (int i = 0; i < length; i++) {
            //查看数组中，在范围start～end 中，数组数字出现的次数
            //如：数组：{2, 3, 1, 0, 2, 5, 3}；范围：1~3(3次)
            //数组数字在1~3范围的有2,3,1,0,2,3,计算了6次，那么在范围1~3内肯定有重复
            //但是也有例外：如数组{1,1,3,4,5,6}，　范围1~3中
            //如果数字出现次数和范围相同，则不能判断是否有重复值
            if (numbers[i] >= start && numbers[i] <= end) {
                ++count;
            }
        }
        return count;
    }


    public static void main(String[] args) {
//        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int[] numbers = {1,1,3,4,5,6};
        int length = numbers.length;
        int duplication = getDuplication(numbers, length);
        System.out.println(duplication);
    }
}
