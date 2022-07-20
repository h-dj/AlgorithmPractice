package org.hdj.AlgorithmPractice.SwordOffer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;


/**
 * @author hdj
 * @version 1.0
 * @date 10/23/19 9:52 AM
 * @description:　反向打印链表
 */
public class PrintListInRevesedOrder {

    /**
     * 头结点
     */
    private ListNode head;

    public PrintListInRevesedOrder() {
        this.head = new ListNode(-1, null);
    }


    /**
     * 使用尾插法，创建链表
     */
    public void insertAtTail(Integer data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        //新建节点
        ListNode newNode = new ListNode(data, null);
        ListNode tail = head.next;
        if (tail != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;
        } else {
            head.next = newNode;
        }
    }

    /**
     * 使用头插法，创建链表
     *
     * @param data
     */
    public void insertAtHead(Integer data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }

        //新建节点
        ListNode newNode = new ListNode(data, null);

        if (head.next == null) {
            head.next = newNode;
        } else {
            ListNode temp = head.next;
            newNode.next = temp;
            head.next = newNode;
        }
    }


    public void display(ListNode head) {
        ListNode next = head.next;
        while (next != null) {
            System.out.print(next.val + " ");
            next = next.next;
        }
    }


    /**
     * 方法1: 翻转打印链表(采用递归形式)
     *
     * @param head
     */
    public void printLinkedListRecursive(ListNode head) {
        //判断参数
        if (head == null) {
            return;
        }
        //如果尾节点不为空，则先访问尾节点
        if (head.next != null) {
            printLinkedListRecursive(head.next);
        }
        if (head.val != -1) {
            System.out.print(head.val + " ");
        }
    }

    public ArrayList<Integer> printLinkedListRecursive2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        //判断参数
        if (head == null) {
            return list;
        }
        //如果尾节点不为空，则先访问尾节点
        if (head.next != null) {
            ArrayList<Integer> temp = printLinkedListRecursive2(head.next);
            list.addAll(temp);
        }
        list.add(head.val);
        return list;
    }

    /**
     * 方法2 :利用栈和循环实现递归翻转打印链表
     */
    public void printLinkedListStack(ListNode head) {
        //判断参数
        if (head == null) {
            return;
        }

        //入栈
        Stack<Integer> stack = new Stack<>();
        ListNode next = head.next;
        while (next != null) {
            stack.push(next.val);
            next = next.next;
        }
        //出栈
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        //判断参数
        if (listNode == null) {
            return list;
        }

        ListNode next = listNode;

        ListNode newHead = null;
        while (next != null) {
            ListNode newNode = new ListNode(next.val);
            if (newHead == null) {
                newHead = new ListNode(-1);
                newHead.next = newNode;
            } else {
                ListNode temp = newHead.next;
                newNode.next = temp;
                newHead.next = newNode;
            }
            next = next.next;
        }
        ListNode n = newHead.next;
        while (n != null) {
            list.add(n.val);
            n = n.next;
        }
        return list;
    }

    public static void main(String[] args) {
        PrintListInRevesedOrder p = new PrintListInRevesedOrder();
        p.insertAtTail(5);
        p.insertAtTail(8);
        p.insertAtTail(9);
        p.insertAtHead(6);
        p.display(p.head);

        System.out.println();
        p.printLinkedListRecursive(p.head);

        System.out.println();

        p.printLinkedListStack(p.head);


        System.out.println("\n+    ");

        ArrayList<Integer> integers1 = p.printLinkedListRecursive2(p.head.next);

        for (Integer integer : integers1) {
            System.out.print(" i=" + integer);
        }

        System.out.println("\n+    ");

        ArrayList<Integer> integers = p.printListFromTailToHead(p.head.next);
        integers.forEach(System.out::print);


        System.out.println();
        p.display(p.head);


    }
}
