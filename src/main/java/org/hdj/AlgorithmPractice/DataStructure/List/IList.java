package org.hdj.AlgorithmPractice.DataStructure.List;

/**
 * @program: AlgorithmPractice
 * @description: 线性表基本操作接口
 * @author: h-dj
 * @create: 2018-11-06 21:26
 **/
public interface IList<E> {
    //线性表清空操作
    void clear();

    // 判空
    boolean isEmpty();

    //长度
    int size();

    //通过下标获取元素
   E get(int i);

    // 插入元素到特定位置
    void insert(int i, E t);

    // 移除元素
    E remove(int i);

    // 查找元素
    int indexOf(E t);

    //打印元素
    void display();
}
