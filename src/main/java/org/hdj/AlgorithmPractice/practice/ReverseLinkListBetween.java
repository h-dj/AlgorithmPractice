package org.hdj.AlgorithmPractice.practice;

/**
 * @Description: 反转链表
 * @Author huangjiajian
 * @Date 2022/7/19 17:45
 */
public class ReverseLinkListBetween {

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


    /**
     * 解法一
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //创建虚拟节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        //1 找到m 节点的前一个节点
        ListNode pre = dummyNode;
        for (int i = 0; i < m; i++) {
            pre = pre.next;
        }

        //2 找到 n 节点
        ListNode rightNode = pre;
        for (int i = 0; i < (n - m + 1); i++) {
            rightNode = rightNode.next;
        }


        //3.截取出一个子链表
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        //4、切断链表
        rightNode.next = null;
        pre.next = null;

        //反转
        //4、反转链表

        ListNode newPre = null;
        ListNode newCur = leftNode;
        while (newCur != null) {
            ListNode newCurNext = newCur.next;
            newCur.next = newPre;
            newPre = newCur;
            newCur = newCurNext;
        }

        //6、接回原来链表
        pre.next = rightNode;
        leftNode.next = cur;

        return dummyNode.next;

    }


    /**
     * 优化
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        //创建一个虚拟节点
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;

        ListNode pre = virtualNode;
        ListNode cur = head;

        //找到反转的开始节点 m
        for (int i = 0; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        //开始反转链表
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return virtualNode.next;


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

        reverseBetween2(node_5, 1, 3);

        print(node_5);

    }
}
