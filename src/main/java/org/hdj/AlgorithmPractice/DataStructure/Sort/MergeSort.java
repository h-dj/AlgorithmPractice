package org.hdj.AlgorithmPractice.DataStructure.Sort;

/**
 * @Auther: h_dj
 * @Date: 2019/2/16 09:45
 * @Description: 归并算法
 *
 * https://pdai.tech/md/algorithm/alg-sort-x-merge.html
 */
public class MergeSort {

    /**
     * 二路归并算法
     */
    public void mergeSort(int[] elements) {
        mergeSortUp2Down(elements, 0, elements.length-1);
    }


    /**
     * 自上而下 合并排序
     *
     * @param elements
     * @param start
     * @param end
     */
    public void mergeSortUp2Down(int[] elements, int left, int right) {
        if (elements ==null || left >= right) {
            return;
        }

        //求中间节点
        int mid = (left + right) / 2;
        //左序列
        mergeSortUp2Down(elements, left, mid);
        //右序列
        mergeSortUp2Down(elements, mid + 1, right);

        //按照顺序合并左右序列
        merge(elements, left, mid, right);
    }

    /**
     * 合并
     *
     * @param elements
     * @param left
     * @param right
     */
    private void merge(int[] elements, int left, int mid, int right) {

        //创建临时数组，保存合并排序的值
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (elements[i] > elements[j]) {
                temp[k++] = elements[j++];
            } else {
                temp[k++] = elements[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = elements[i++];
        }

        while (j <= right) {
            temp[k++] = elements[j++];
        }

        // 将排序后的元素，全部都整合到数组a中。
        for (i = 0; i < k; i++) {
            elements[left + i] = temp[i];
        }

        temp = null;

    }


}
