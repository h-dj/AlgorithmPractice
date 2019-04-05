package org.hdj.AlgorithmPractice.DataStructure.Search;

/**
 * @Auther: h_dj
 * @Date: 2019/2/19 12:00
 * @Description: 二分法查找
 */
public class BinarySearch {

    /**
     * 二分法查找
     *
     * @return
     */
    public int binarySearch(int[] elements, int key) {

        int low, high, mid;

        //上界，序列开始
        low = 0;
        //下界，序列尾部
        high = elements.length - 1;
        while (low <= high) {
            //找出序列的中间元素索引
            mid = (low + high) / 2;

            if (elements[mid] > key) {
                //如果查找的关键字比中间元素小， 则在范围low ~ mid -1 里找
                high = mid - 1;
            } else if (elements[mid] < key) {
                //如果查找的关键字比中间元素大， 则在范围mid + 1 ~ high 里找
                low = mid + 1;
            } else {
                //否则，返回匹配元素的索引
                return mid;
            }
        }
        return -1;
    }
}
