package org.hdj.AlgorithmPractice.DSJD2E.Search;

import org.hdj.AlgorithmPractice.DSJD2E.List.LinkedList.LNode;
import org.hdj.AlgorithmPractice.DSJD2E.List.LinkedList.LinkedList;

/**
 * @Auther: h_dj
 * @Date: 2019/2/25 22:29
 * @Description: 实现hashTable
 * <p>
 * 采用链地址法，解决哈希冲突问题
 */
public class HashTable<E> {

    //哈希表的对象数组
    public LinkedList[] table;

    public HashTable(int size) {
        table = new LinkedList[size];
        //构造空链表
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList();
        }
    }

    //哈希函数
    //采用除留余数法
    public int hash(int key) {
        return key % table.length;
    }

    /**
     * 插入
     */
    public void insert(E element) {
        //插入关键字的哈希码
        int key = element.hashCode();
        //计算哈希值
        int hash = hash(key);
        //插入元素
        table[hash].insert(0, element);
    }

    /**
     * 搜索
     *
     * @return
     */
    public LNode search(E element) {
        //获取元素的哈希码
        int key = element.hashCode();
        //获取元素的存储哈希值
        int hash = hash(key);
        //获取元素在对应哈希槽链表的索引
        int index = table[hash].indexOf(element);
        if (index >= 0) {
            return (LNode) table[hash].get(index);
        }
        return null;
    }

    /**
     * 包含
     *
     * @return
     */
    public boolean contain(E element) {
        return search(element) != null;
    }

    /**
     * @param element
     * @return
     */
    public boolean remove(E element) {
        int key = element.hashCode();
        int hash = hash(key);
        int index = table[hash].indexOf(element);
        if (index >= 0) {
            table[hash].remove(index);
            return true;
        }
        return false;


    }
}
