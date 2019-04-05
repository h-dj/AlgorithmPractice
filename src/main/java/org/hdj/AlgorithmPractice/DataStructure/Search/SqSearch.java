package org.hdj.AlgorithmPractice.DataStructure.Search;

/**
 * @Auther: h_dj
 * @Date: 2019/2/19 11:26
 * @Description: 顺序表查找
 */
public class SqSearch {

    /**
     * 顺序表查找算法
     * 无哨兵
     *
     * @return
     */
    public int seqSearch(int[] elements, int key) {
        for (int i = 0, len = elements.length; i < len; i++) {
            if (elements[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 顺序表查找算法
     * 哨兵
     * @return
     */
    public int seqSearchWithGurd(int[] elements, int key) {
        //元素下标, 从序列尾部开始
        int i = elements.length - 1;
        //作为哨兵
        elements[0] = key;
        while (elements[i] != key) {
            i--;
        }
        //返回下标
        return i > 0 ? i : -1;
    }
}
