package org.hdj.AlgorithmPractice.DataStructure.Sort;

import java.util.Comparator;

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
    public static void sort(int[] elements) {

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


    //排序器
    public interface Sortor {

        //排序实现了comparable接口的对象数据
        public <T extends Comparable<T>> void sort(T[] list);

        //通过传入的比较器Comparator对数组进行排序
        public <T> void sort(T[] list, Comparator<T> comparator);
    }

    public class BasicBubbleSortor implements Sortor {

        @Override
        public <T extends Comparable<T>> void sort(T[] list) {
            boolean swapped = true;
            for (int i = 1, len = list.length; i < len && swapped; ++i) {
                swapped = false;
                for (int j = 0; j < len - i; ++j) {
                    if (list[j].compareTo(list[j + 1]) > 0) {
                        T temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                        swapped = true;
                    }
                }
            }
        }

        @Override
        public <T> void sort(T[] list, Comparator<T> comparator) {
            boolean swapped = true;
            for (int i = 1, len = list.length; i < len && swapped; ++i) {
                swapped = false;
                for (int j = 0; j < len - i; ++j) {
                    if (comparator.compare(list[j], list[j + 1]) > 0) {
                        T temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                        swapped = true;
                    }
                }
            }
        }
    }


}
