package org.hdj.AlgorithmPractice.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2022/7/26 14:12
 */
public class MergeKLists {

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


    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(5, null);
        ListNode node_2 = new ListNode(4, node_1);
        ListNode node_3 = new ListNode(3, node_2);
        ListNode node_4 = new ListNode(2, node_3);
        ListNode node_5 = new ListNode(1, node_4);


        ListNode node_a = new ListNode(10, null);
        ListNode node_b = new ListNode(9, node_a);
        ListNode node_c = new ListNode(8, node_b);
        ListNode node_d = new ListNode(7, node_c);
        ListNode node_e = new ListNode(6, node_d);

        print(node_5);

        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(node_5);
        lists.add(node_e);

        ListNode listNode = mergeKLists(lists);

        print(listNode);
    }

    /**
     * 合并k有序链表
     *
     * @param lists
     * @return
     */
    private static ListNode mergeKLists(ArrayList<ListNode> lists) {
        return dividLists(lists, 0, lists.size() - 1);
    }

    /**
     * 分割列表
     *
     * @param lists
     * @param left
     * @param right
     * @return
     */
    private static ListNode dividLists(ArrayList<ListNode> lists, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return lists.get(left);
        }

        int mid = (left + right) / 2;

        //合并两个有序链表
        return merge(dividLists(lists, left, mid), dividLists(lists, mid + 1, right));
    }

    /**
     * 合并左右链表
     *
     * @param left
     * @param right
     * @return
     */
    private static ListNode merge(ListNode left, ListNode right) {

        ListNode leftTemp = left;
        ListNode rightTemp = right;

        //虚拟节点
        ListNode virtualNode = new ListNode(-1);

        //当前节点
        ListNode cur = virtualNode;

        while (leftTemp != null && rightTemp != null) {

            if (leftTemp.val > rightTemp.val) {
                cur.next = rightTemp;
                rightTemp = rightTemp.next;
            } else {
                cur.next = leftTemp;
                leftTemp = leftTemp.next;
            }
            cur = cur.next;
        }

        if (leftTemp != null) {
            cur.next = leftTemp;
        }

        if (rightTemp != null) {
            cur.next = rightTemp;
        }

        return virtualNode.next;
    }
}
