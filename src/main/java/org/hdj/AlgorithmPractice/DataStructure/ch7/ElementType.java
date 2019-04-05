package org.hdj.AlgorithmPractice.DataStructure.ch7;

/**
 * @Auther: h_dj
 * @Date: 2019/2/9 22:36
 * @Description: 顺序表记录结点类
 */
public class ElementType<T> {

    public T data;

    public ElementType(T data) {
        this.data = data;
    }

    public ElementType() {

    }

    @Override
    public String toString() {
        return "ElementType{" +
                "data=" + data +
                '}';
    }
}
