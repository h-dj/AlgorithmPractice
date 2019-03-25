package org.hdj.AlgorithmPractice.DSJD2E.List.SqList;

import org.hdj.AlgorithmPractice.DSJD2E.List.IList;

/**
 * @Author h-dj
 * <p>
 * 顺序表 抽象接口的实现
 */
public class SqList<E> implements IList<E> {
    //顺序表存储空间
    private Object[] objects;
    //顺序表的初始化大小
    private int initCapacity = 10;
    //顺序表当前长度
    private int lenght = 0;

    public SqList() {
        objects = new Object[this.initCapacity];
    }

    public SqList(int initCapacity) {
        this.initCapacity = initCapacity;
        objects = new Object[this.initCapacity];
    }

    /**
     * 清空顺序表
     */
    @Override
    public void clear() {
        //把顺序表置空; 帮助垃圾回收
        for (int i = 0; i < this.lenght; i++)
            objects[i] = null;
        //重置当前长度lenght
        this.lenght = 0;
    }

    /**
     * 判断顺序表是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        //如果顺序表当前的长度为0， 则为空
        return this.lenght == 0;
    }

    /**
     * 顺序表当前的长度
     *
     * @return
     */
    @Override
    public int size() {
        return this.lenght;
    }

    /**
     * 获取相应下标的元素
     *
     * @param i
     * @return
     */
    @Override
    public E get(int i) {
        // 首先，先判度下标 i 是否合法
        if (i < 0 || i >= this.lenght)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.lenght);
        return (E) objects[i];
    }

    /**
     * 插入元素到指定下标
     */
    @Override
    public void insert(int i, E t) {
        // 首先，先判度下标 i 是否合法
        if (i < 0 || i > this.lenght)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.lenght);

        //判断是否超出顺序表的容量
        if (this.lenght >= this.objects.length)
            throw new ArrayIndexOutOfBoundsException("length = " + this.lenght + " Capacity" + this.initCapacity);

        //把下标为i及其后的元素，往后移移一位
        for (int j = this.lenght - 1; j >= i; --j) {
            objects[j + 1] = objects[j];
        }
        //插入元素
        objects[i] = t;
        lenght++;
    }

    public void insert(E t) {
        insert(this.lenght, t);
    }

    /**
     * 移除给定下标元素
     */
    @Override
    public E remove(int i) {
        // 首先，先判度下标 i 是否合法
        if (i < 0 || i > this.lenght)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.lenght);
        //获取删除的元素
        E removeObj = (E) objects[i];
        //把下标为i及其后的元素，往前移移一位
        for (int j = i; j < this.lenght - 1; j++) {
            objects[j] = objects[j + 1];
        }
        //把最后一个元素置空，帮助垃圾回收
        objects[lenght - 1] = null;
        //当前线性表长度减一
        --lenght;
        return removeObj;
    }

    /**
     * 获取元素的下标, 找不到返回-1
     */
    @Override
    public int indexOf(E e) {
        //先判断 元素是否为空，可防止空指针的出现
        if (e == null) {
            //为空则，返回顺序表中空元素的下标
            for (int i = 0; i < this.lenght; i++)
                if (objects[i] == null)
                    return i;
        } else {
            //不为空，则返回与之匹配的元素下标
            for (int i = 0; i < this.lenght; i++)
                if (e.equals(objects[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public void display() {
        //打印所有元素
        for (int i = 0; i < this.lenght; i++) {
            System.out.println(objects[i]);
        }
    }
}
