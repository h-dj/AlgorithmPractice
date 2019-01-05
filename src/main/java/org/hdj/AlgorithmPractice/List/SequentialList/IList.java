package org.hdj.AlgorithmPractice.List.SequentialList;

/**
 * @program: AlgorithmPractice
 * @description: 线性顺序存储结构练习之 基本操作接口
 * @author: Coder
 * @create: 2018-11-06 21:26
 **/
public interface IList<T>{

    //线性表清空操作
    void clear();

    // 判空
    boolean isEmpty();
    //长度
    int size();
    //通过下标获取元素
    T get(int i);

    // 插入元素
    void insert(int i,T t);
    // 移除元素
    void remove(int i);

    // 查找元素
    int indexOf(T t);
}
