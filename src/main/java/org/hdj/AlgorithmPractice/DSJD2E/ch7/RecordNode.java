package org.hdj.AlgorithmPractice.DSJD2E.ch7;

/**
 * @Auther: h_dj
 * @Date: 2019/2/9 22:30
 * @Description: 待排序记录
 */
public class RecordNode {

    public Comparable key;
    public Object element;

    public RecordNode(Comparable key, Object element) {
        this.key = key;
        this.element = element;
    }

    public RecordNode(Comparable key) {
        this.key = key;
    }

}
