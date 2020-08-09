package org.hdj.AlgorithmPractice.SwordOffer;

import java.util.Stack;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/7/31 下午12:47
 * @description:　翻转链表 和 翻转链表打印
 * 1. 第一种解法
 * 使用头插入法， 构造新的链表
 * 2. 递归
 * 3. 双指针
 */
public class ReversePrint_06 {

    /**
     * 利用栈(会导致扩容，进行数组拷贝)
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    /**
     * 先计算链表的长度
     *
     * @param head
     * @return
     */
    public static int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        int len = 0;
        ListNode point = head;
        while (point != null) {
            len++;
            point = point.next;
        }
        int[] result = new int[len];
        point = head;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = point.val;
            point = point.next;
        }
        return result;
    }


    /**
     * 翻转链表
     * 使用头插法构造新链表进行翻转
     *
     * @param node
     * @return
     */
    public static ListNode reverse(ListNode node) {
        ListNode listNode = null;
        while (node != null) {
            if (listNode == null) {
                listNode = new ListNode(node.val);
            } else {
                ListNode n = new ListNode(node.val);
                n.next = listNode;
                listNode = n;
            }
            node = node.next;
        }
        return listNode;
    }

    /**
     * 翻转链表
     * 递归
     *
     * @param node
     * @return
     */
    public static ListNode reverse2(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        //递归，直到倒数第二个节点
        ListNode listNode = reverse2(node.next);
        //让当前结点的下一个结点的 nextnext 指针指向当前节点。
        //使得指针的方向调转
        node.next.next = node;
        //当前下一个指针置空, 防止循环引用
        node.next = null;
        return listNode;
    }

    /**
     * 翻转链表
     * 使用双指针
     *
     * @param node
     * @return
     */
    public static ListNode reverse3(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        //当前指针
        ListNode current = null;
        //前一个指针
        ListNode pre = node;
        while (pre != null) {
            //保存下一个指针
            ListNode next = pre.next;
            //指针翻转
            pre.next = current;
            //操作下一个节点
            current = pre;
            pre = next;
        }
        return current;
    }


    public static void main(String[] args) {
//        int[] ints = reversePrint(genNode(1, 6));
//        System.out.println(Arrays.toString(ints));


        Utils.display(Utils.genNode(1, 6));
        ListNode reverse = reverse(Utils.genNode(1, 6));
        Utils.display(reverse);

        reverse = reverse2(Utils.genNode(1, 6));
        Utils.display(reverse);

        reverse = reverse3(Utils.genNode(1, 6));
        Utils.display(reverse);
    }
}
