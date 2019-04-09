package org.hdj.AlgorithmPractice.DataStructure.Sort;

/**
 * @Auther: h_dj
 * @Date: 2019/2/13 16:33
 * @Description: 直接选择排序
 */
public class DirectSelectionSort {


    /**
     * @param elements
     */
    public static void straightSelectionSort(int[] elements) {
        int i, j, minIndex;
        //n-1趟排序
        for (i = 0; i < elements.length - 1; i++) {
            //定义最小值索引为 i
            minIndex = i;
            //从i+1开始，找最小值
            for (j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[minIndex]) {
                    //记录最小值索引
                    minIndex = j;
                }
            }

            //如果最小值索引不等于i, 则与i交换位置
            if (minIndex != i) {
                int temp = elements[i];
                elements[i] = elements[minIndex];
                elements[minIndex] = temp;
            }

        }
    }


}
