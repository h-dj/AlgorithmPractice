package org.hdj.AlgorithmPractice.LeetCode.algorithm;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Description: LFUCache 缓存实现
 * @Author huangjiajian
 * @Date 2022/3/12 下午10:23
 */
public class LFUCache {

    /**
     * 头部指针
     */
    private Node head;
    /**
     * 尾部指针
     */
    private Node tail;

    private int capacity; // 容量限制
    private int size; // 当前数据个数
    private Map<Integer, Node> map; // key和数据的映射

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node(0, 0, 0);
        this.tail = new Node(0, 0, 0);
        this.head.next = tail;
        this.tail.pre = head;
        this.map = new HashMap<>();
    }


    public Integer get(Integer key){
        //获取数据
        Node node=map.get(key);
        if(node == null){
            return null;
        }
        // 如果存在则增加该数据的访问频次
        freqPlus(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (capacity <= 0) {
            return;
        }
        Node node = map.get(key);
        if (node != null) {
            // 如果存在则增加该数据的访问频次
            node.value = value;
            freqPlus(node);
        } else {
            // 淘汰数据
            eliminate();
            Node newNode = new Node(key, value, 0);
            map.put(key, newNode);
            size++;

            // 将新数据插入到末尾
            Node tailPre = tail.pre;
            tail.pre = newNode;
            newNode.pre = tailPre;
            newNode.next = tail;
            tailPre.next = newNode;
            // 增加访问频次
            freqPlus(newNode);
        }
    }

    private void eliminate() {

        if (size < capacity) {
            return;
        }

        // 从尾结点的pre节点之间删除即可
        Node last = tail.pre;
        last.pre.next = tail;
        tail.pre = last.pre;
        map.remove(last.key);
        size--;
        last = null;
    }


    /**
     * 添加访问频次
     * @param node
     */
    private void freqPlus(Node node) {
        //增加频次
        node.frequency++;
        Node temp = node.pre;
        int freq = node.frequency;

        //调整顺序
        while (temp!=null){
            if(temp.frequency > freq || temp == head){
                //找到访问频次比当前 node 大的节点，
                //先调整当前节点
                node.pre.next = node.next;
                node.next.pre = node.pre;

                Node tempNode = temp.next;
                temp.next = node;
                tempNode.pre = node;
                node.next = tempNode;
                node.pre= temp;
                break;
            }
            temp = temp.pre;
        }
    }

    public void display(){
        Node temp = this.head.next;
        while (temp!=this.tail){
            System.out.println(temp.value +" ===> "+temp.frequency);
            temp = temp.next;
        }
        System.out.println();
    }


}


class Node{
    //key
    int key;
    //值
    int value;
    //访问频率
    int frequency;

    //前驱指针
    Node pre;
    //后驱指针
    Node next;

    public Node(int key, int value, int frequency) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
        this.pre = pre;
        this.next = next;
    }
}