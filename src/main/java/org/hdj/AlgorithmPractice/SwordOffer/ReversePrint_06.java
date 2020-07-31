package org.hdj.AlgorithmPractice.SwordOffer;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/7/31 下午12:47
 * @description:　翻转链表
 */
public class ReversePrint_06 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode genNode(int start, int length) {
        ListNode h = new ListNode(start);
        if (start == length) {
            return h;
        }
        h.next = genNode(start + 1, length);
        return h;
    }


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


    public static void main(String[] args) {
        int[] ints = reversePrint(genNode(1, 6));
        System.out.println(Arrays.toString(ints));
    }
}
