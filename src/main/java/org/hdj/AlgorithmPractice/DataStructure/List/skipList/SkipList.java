package org.hdj.AlgorithmPractice.DataStructure.List.skipList;

import java.util.Comparator;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Description: 跳跃表
 * @Author huangjiajian
 * @Date 2021/7/16 16:42
 * <p>
 * https://juejin.cn/post/6910476641990868999
 */
public class SkipList<K extends Comparable<K>, V> {

    public static final int DEFAULT_HEIGHT_LEVEL = 32;

    //头指针
    private Node head;
    //元素大小
    private int size;

    private Random r;
    /**
     * 层级
     */
    private int heightLevel;
    private int maxLevel;

    public SkipList() {
        this(DEFAULT_HEIGHT_LEVEL);
    }

    public SkipList(int maxLevel) {
        //头指针
        this.head = new Node<>(null, null);
        //跳表元素个数
        this.size = 0;
        this.r = new Random();
        this.heightLevel = 0;
        this.maxLevel = maxLevel;
    }


    protected static class Node<K extends Comparable<K>, V> {
        //key
        private K key;
        //对应的值
        private V value;
        // 下 、 右 指针
        Node<K, V> down, right;

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        public Node(K key, V value, Node<K, V> down, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.down = down;
            this.right = right;
        }
    }

    /**
     * 查找节点
     *
     * @param key
     * @return
     */
    private Node findNode(K key) {
        Node p = this.head.right;
        while (p != null) {
            if (p.key.compareTo(key) == 0) {
                return p;
            } else if (p.right == null || p.right.key.compareTo(key) > 0) {
                //向下查找
                p = p.down;
            } else {
                //查找右侧
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 查询
     *
     * @param key
     * @return
     */
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        Node<K, V> n = findNode(key);
        if (n != null) {
            return n.value;
        }
        return null;
    }

    /**
     * 添加
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {

        if (key == null) {
            throw new NullPointerException();
        }

        Node<K, V> node = findNode(key);

        //如果节点已存在
        if (node != null) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        //存储向下的节点，这些节点可能在右侧插入节点
        Stack<Node> stack = new Stack<Node>();
        //查找待插入的节点   找到最底层的哪个节点。
        Node p = this.head;
        while (p != null) {
            //右侧没有了，只能下降
            if (p.right == null || p.right.key.compareTo(key) > 0) {
                //将曾经向下的节点记录一下
                stack.add(p);
                p = p.down;
            } else {
                //向右
                p = p.right;
            }
        }

        //当前层数，从第一层添加(第一层必须添加，先添加再判断)
        int level = 1;
        //保持前驱节点(即down的指向，初始为null)
        Node downNode = null;
        while (!stack.isEmpty()) {
            //在该层插入node
            p = stack.pop();
            Node nodeTeam = new Node(key, value);
            nodeTeam.down = downNode;
            //标记新的节点下次使用
            downNode = nodeTeam;
            //右侧为null 说明插入在末尾
            if (p.right == null) {
                p.right = nodeTeam;
            }
            //水平方向处理
            else {//右侧还有节点，插入在两者之间
                nodeTeam.right = p.right;
                p.right = nodeTeam;
            }
            //考虑是否需要向上
            if (level > this.maxLevel) {
                break;
            }
            //[0-1]随机数
            double num = r.nextDouble();
            if (num > 0.5) {
                break;
            }
            level++;
            //比当前最大高度要高但是依然在允许范围内 需要改变head节点
            if (level > this.heightLevel) {
                this.heightLevel = level;
                //需要创建一个新的节点
                Node highHeadNode = new Node(null, null);
                highHeadNode.down = this.head;
                //改变head
                this.head = highHeadNode;
                //下次抛出head
                stack.add(this.head);
            }
        }
        this.size++;

        return null;
    }

    /**
     * 删除节点
     *
     * @return
     */
    public void remove(K key) {
        if (key == null) {
            throw new NullPointerException();
        }

        Node node = this.head;
        while (node != null) {
            //如果右指针为空，则向下查找
            if (node.right == null) {
                node = node.down;
            } else if (node.right.key.compareTo(key) > 0) {
                //如果右节点key 大于 搜索key，则向下搜索
                node = node.down;
            } else if (node.right.key.compareTo(key) == 0) {
                //如果当前节点的右指针节点的key 与搜索key 相等
                //删除节点
                node.right = node.right.right;
                //向下
                node = node.down;
            } else {
                //否则向右查找
                node = node.right;
            }
        }

    }

    public int size() {
        return this.size;
    }

    public void printList() {
        Node teamNode = this.head;
        Node last = teamNode;
        while (last.down != null) {
            last = last.down;
        }
        while (teamNode != null) {
            Node enumNode = teamNode.right;
            Node enumLast = last.right;
            System.out.printf("%-8s", "head->");
            while (enumLast != null && enumNode != null) {
                if (enumLast.key == enumNode.key) {
                    System.out.printf("%-5s", enumLast.key + "->");
                    enumLast = enumLast.right;
                    enumNode = enumNode.right;
                } else {
                    enumLast = enumLast.right;
                    System.out.printf("%-5s", "");
                }

            }
            teamNode = teamNode.down;
            System.out.println();
        }
    }


    public static void main(String[] args) {
        SkipList skipList = new SkipList();

        for (int i = 0; i < 20; i++) {
            skipList.put(i, Math.random());
        }
        skipList.printList();

        Object o = skipList.get(2);
        System.out.println(o);

        System.out.println(skipList.size());


        skipList.remove(2);

        skipList.printList();


    }
}
