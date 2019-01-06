package org.hdj.AlgorithmPractice.List.SequentialList;

import org.hdj.AlgorithmPractice.List.IList;

/**
 * @Author hdj
 * <p>
 * 顺序表 抽象接口的实现
 */
public class SqList<T> implements IList<T> {
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
    public T get(int i) {
        // 首先，先判度下标 i 是否合法
        if (i < 0 || i >= this.lenght)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.lenght);
        return (T) objects[i];
    }

    /**
     * 插入元素到指定下标
     * <p>
     * 算法分析
     * 1. 问题的规模
     * 　     表的长度L-＞length（设值为n）是问题的规模。
     * 2. 移动结点的次数由表长n和插入位置i决定; 0<= i <= n
     * - 算法的时间主要花费在for循环中的结点后移语句上。该语句的执行次数是n-i。
     * - 当i=n：移动结点次数为0，即算法在最好时间复杂度是0(1)
     * - 当i=0：移动结点次数为n，即算法在最坏情况下时间复杂度是0(n)
     * - 所以平均移动次数：
     * Pi * [(n-i) 的和 ]; 0<= i <=n;
     * Pi表示为在顺序表中插入第 i个元素前的概率；假设相等，Pi = 1/(n+1)
     * [(n-i) 的和 ] = n+ (n-1) + ...+1+0 = n*(n+1)/2
     * - 时间复杂度为：
     * Pi * [(n-i) 的和 ] = [ 1/(n+1) ]  * [ n*(n+1)/2 ] = n/2 = O(n)
     *
     * @param i
     * @param t
     */
    @Override
    public void insert(int i, T t) {
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

    public void insert(T t) {
        insert(this.lenght, t);
    }

    /**
     * 移除给定下标元素
     * <p>
     * 算法分析
     * <p>
     * 结点的移动次数由表长n和位置i决定： 0<=i <=n-1
     * 　i=n-1时，结点的移动次数为0，即为0(1)
     * 　i=0时，结点的移动次数为n-1，算法时间复杂度分别是0(n)
     * 移动结点的平均次数:
     * Pi * [(n-i-1)的和]
     * Pi 删除顺序表第i个元素的概率； Pi = 1/n
     * [(n-i-1)的和] = (n-1) + (n-2)+ ....+ 1+0 = n(n-1)/2
     * 时间复杂度为;
     * Pi * [(n-i-1)的和] = 1/n * [n(n-1)/2 ] = (n-1)/2 = O(n)
     *
     * @param i
     * @return
     */
    @Override
    public T remove(int i) {
        // 首先，先判度下标 i 是否合法
        if (i < 0 || i > this.lenght)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.lenght);
        //获取删除的元素
        T removeObj = (T) objects[i];
        //把下标为i及其后的元素，往前移移一位
        for (int j = i; j < this.lenght - 1; j++) {
            objects[j] = objects[j + 1];
        }
        //把最后一个元素置空，帮助垃圾回收
        objects[lenght - 1] = null;
        //当前线性表长度减一
        lenght--;
        return removeObj;
    }

    /**
     * 获取元素的下标, 找不到返回-1
     * <p>
     * 算法分析
     * <pre>
     *      结点的遍历次数由 查找元素所在位置决定的： 0<= i <=n-1
     *      当查找元素位置 在第一位时，i= 0; 时间复杂度为 O(1)
     *      当查找元素位置 在最后一位时，i= n-1; 时间复杂度为 O(n)
     *      遍历每个元素的概率 Pi = 1/n
     *      平均遍历次数： Pi * [(i+1)的和]
     *      [(i+1)的和] = 1+2+...+n = n* (n+1)/2
     * </pre>
     * <p>
     * 时间复杂度为;
     *Pi * [(i+1)的和] = [1/n] * [n* (n+1)/2] = (n+1)/2 = O(n)
     * @param t
     * @return
     */
    @Override
    public int indexOf(T t) {
        //先判断 元素是否为空，可防止空指针的出现
        if (t == null) {
            //为空则，返回顺序表中空元素的下标
            for (int i = 0; i < this.lenght; i++)
                if (objects[i] == null)
                    return i;
        } else {
            //不为空，则返回与之匹配的元素下标
            for (int i = 0; i < this.lenght; i++)
                if (t.equals(objects[i]))
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
