package org.hdj.AlgorithmPractice.practice;

/**
 * @Description: 反转链表，每k组反转
 * @Author huangjiajian
 * @Date 2022/7/19 17:45
 */
public class ReverseLinkListGroup {

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode reverseGroup(ListNode head, int k) {

        //每次找到反转的尾部
        ListNode tailNode = head;
        for (int i = 0; i < k; i++) {
            // 不足k 个，到达链表尾部，直接返回
            if (tailNode == null) {
                return head;
            }
            tailNode = tailNode.next;
        }

        //反转时，需要的前置节点和当前节点
        ListNode pre = null;
        ListNode cur = head;

        while (cur != tailNode) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        head.next = reverseGroup(tailNode,k);

        return pre;
    }


    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1, null);
        ListNode node_2 = new ListNode(2, node_1);
        ListNode node_3 = new ListNode(3, node_2);
        ListNode node_4 = new ListNode(4, node_3);
        ListNode node_5 = new ListNode(5, node_4);

        print(node_5);

        ListNode listNode = reverseGroup(node_5, 2);

        print(listNode);

    }
}
