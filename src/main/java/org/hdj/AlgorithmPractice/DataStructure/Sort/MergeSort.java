package org.hdj.AlgorithmPractice.DataStructure.Sort;

/**
 * @Auther: h_dj
 * @Date: 2019/2/16 09:45
 * @Description: 归并算法
 */
public class MergeSort {

    /**
     * 归并两个相邻的有序表r[h]-r[m] 和r[m+1]-r[t] 归并为r[h]-r[t]
     *
     * @param r     待排序序列
     * @param order 归并后序列
     * @param h     第一个有序表第一个元素的下标
     * @param m     第一个有序表第最后元素的下标
     * @param t     第二个有序表第最后元素的下标
     */
    public void merge(int[] r, int[] order, int h, int m, int t) {
        int i = h, j = m + 1, k = h;

        //将r中两个相邻子序列归并到order中
        while (i <= m && j <= t) {
            //较小值复制到order中
            if (r[i] <= r[j]) {
                order[k++] = r[i++];
            } else {
                order[k++] = r[j++];
            }
        }

        //将前一个子序列剩余元素复制到order中
        while (i <= m) {
            order[k++] = r[i++];
        }

        //将后一个子序列剩余元素复制到order中
        while (j <= t) {
            order[k++] = r[j++];
        }
    }

    /**
     * 归并排序
     *
     * @param r     待排序序列
     * @param order 归并结果序列
     * @param s     待归并有序子序列的长度
     * @param n     待排序序列长度
     */
    public void mergepass(int[] r, int[] order, int s, int n) {
        //定义每对待合并表的第一个元素的下标，初始值为0
        int p = 0;
        //两两归并长度均为s的有序表
        //p: 有序表的开始元素下标，p+s-1: 有序表的结束元素下标
        while (p + 2 * s - 1 <= n - 1) {
            merge(r, order, p, p + s - 1, p + 2 * s - 1);
            p = p + 2 * s;
        }
        //归并最后两个长度不等的有序表
        if (p + s - 1 < n - 1) {
            merge(r, order, p, p + s - 1, n - 1);
        } else {
            //将剩余有序表复制到order中
            for (int i = p; i <= n - 1; i++) {
                order[i] = r[i];
            }
        }
    }


    /**
     * 二路归并算法
     */
    public void mergeSort(int[] elements) {
        int s = 1;
        int len = elements.length;
        int[] temp = new int[len];
        while (s < len) {

            mergepass(elements, temp, s, len);
            s = s * 2;
            mergepass(temp, elements, s, len);
            s = s * 2;
        }
    }
}
