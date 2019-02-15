package org.hdj.AlgorithmPractice.Sort;

/**
 * @Auther: h_dj
 * @Date: 2019/2/12 10:30
 * @Description: 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * <p>
     * 空间复杂度：O(1)
     * 时间复杂度： O(n^2)
     *
     * @param elements
     */
    public void sort(int[] elements) {

        //标识序列是否发生交换
        boolean swap_flag = true;
        for (int i = 0, len = elements.length; i < len && swap_flag; i++) {
            //标识没有发生交换
            swap_flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    //标识交换
                    swap_flag = true;
                }
            }
        }
    }
}
