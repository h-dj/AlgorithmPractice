package org.hdj.AlgorithmPractice.SwordOffer;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/7/29 下午10:22
 * @description: 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 *  
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class GetKthFromEnd_22 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂的 O(N)
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        //遍历链表
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        temp = head;
        int end = (length - k);
        for (int i = 0; i < end; i++) {
            temp = temp.next;
        }
        return temp;
    }


    /**
     * 时间复杂的 O(N)
     * <p>
     * 双指针
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode start = head, end = head;
        //start指针移动k步
        for (int i = 0; i < k; i++) {
            start = start.next;
        }
        //start 和 end 指针同时移动
        while (start != null) {
            start = start.next;
            end = end.next;
        }
        return end;
    }

    public static ListNode genNode(int start, int length) {
        ListNode h = new ListNode(start);
        if (start == length) {
            return h;
        }
        h.next = genNode(start + 1, length);
        return h;
    }

    public static void main(String[] args) {
        ListNode listNode = genNode(1, 5);
        ListNode kthFromEnd = getKthFromEnd(listNode, 2);
        System.out.println(kthFromEnd.val);

        kthFromEnd = getKthFromEnd2(listNode, 2);
        System.out.println(kthFromEnd.val);
    }
}
