package org.hdj.AlgorithmPractice.DSJD2E.List.LinkedList;


import org.hdj.AlgorithmPractice.DSJD2E.List.IList;

/**
 * 循环链表的实现
 *
 * @param <T>
 */
public class CircularLinkedList<T> implements IList<T> {

    //链表的尾指针
    private LNode tail;
    //长度
    private int length;

    public CircularLinkedList() {
        tail = null;
        length = 0;
    }

    @Override
    public void clear() {
        tail = null;
        length = 0;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    /**
     * 通过索引查找
     */
    @Override
    public T get(int i) {
        if (i < 0 || i > length - 1)
            throw new RuntimeException("查找元素不存在：i=" + i);

        //计数器
        int index = 0;
        //获取第一个元素
        LNode p = tail.next;
        while (index != i && p != tail) {
            index++;
            p = p.next;
        }
        return (T) p.data;
    }

    /**
     * 插入结点
     *
     * @param i
     * @param t
     */
    @Override
    public void insert(int i, T t) {
        //判读插入位置是否合法
        if (i < 0 || i > length)
            throw new RuntimeException("插入的位置不合法：i=" + i);

        //判断链表是否为空
        if (isEmpty()) {
            tail = new LNode(t);
            tail.next = tail;
        } else {
            //计数器
            int index = 0;
            //获取第一个元素
            LNode p = tail.next;
            while (index < (i - 1) && p != tail) {
                index++;
                p = p.next;
            }

            //创建结点
            LNode<T> newNode = new LNode<>(t);
            //如果插入的位置是第一个
            if (i == 0) {
                newNode.next = tail.next;
                tail.next = newNode;
            } else if (i == length) {
                //插入最后一个
                newNode.next = tail.next;
                tail.next = newNode;
                tail = newNode;
            } else {
                newNode.next = p.next;
                p.next = newNode;
            }
        }

        //链表长度加一
        length++;
    }

    @Override
    public T remove(int i) {
        if (i < 0 || i > length - 1)
            throw new RuntimeException("删除的元素不存在 ：i=" + i);

        //计数器
        int index = 0;
        //获取第一个元素
        LNode p = tail.next;
        while (index < (i - 1) && p != tail) {
            index++;
            p = p.next;
        }

        //删除的结点
        LNode remove = null;

        if (i == 0) {
            remove = p;
            tail.next = p.next;
        } else if (i == length - 1) {
            remove = tail;
            p.next = tail.next;
            tail = p;
        } else {
            remove = p.next;
            p.next = p.next.next;
        }
        //长度减一
        length--;
        return (T) remove.data;
    }

    @Override
    public int indexOf(T t) {
        //计数器
        int index = 0;
        //获取第一个元素
        LNode p = tail.next;
        do {
            if (p.data.equals(t)) {
                return index;
            }
            index++;
            p = p.next;
        } while (p != tail.next);
        return -1;
    }

    @Override
    public void display() {
        //判断是否为空
        if (isEmpty()) {
            System.out.println("链表为空！");
            return;
        }
        //获取第一个元素
        LNode p = tail.next;
        do {
            System.out.println(p.data);
            p = p.next;
        } while (p != tail.next);
    }
}
