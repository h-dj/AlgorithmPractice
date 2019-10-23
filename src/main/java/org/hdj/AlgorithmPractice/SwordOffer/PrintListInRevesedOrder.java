package org.hdj.AlgorithmPractice.SwordOffer;

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
    private Node head;

    public PrintListInRevesedOrder() {
        this.head = new Node(null, null);
    }

    private class Node {
        Integer data;
        Node next;


        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 使用尾插法，创建链表
     */
    public void insertAtTail(Integer data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        //新建节点
        Node newNode = new Node(data, null);
        Node tail = head.next;
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
        Node newNode = new Node(data, null);

        if (head.next == null) {
            head.next = newNode;
        } else {
            Node temp = head.next;
            newNode.next = temp;
            head.next = newNode;
        }
    }


    public void display() {
        Node next = head.next;
        while (next != null) {
            System.out.print(next.data + " ");
            next = next.next;
        }
    }


    /**
     * 方法1: 翻转打印链表(采用递归形式)
     *
     * @param head
     */
    public void printLinkedListRecursive(Node head) {
        //判断参数
        if (head == null) {
            return;
        }
        //如果尾节点不为空，则先访问尾节点
        if (head.next != null) {
            printLinkedListRecursive(head.next);
        }
        if (head.data != null) {
            System.out.print(head.data + " ");
        }
    }

    /**
     * 方法2 :利用栈和循环实现递归翻转打印链表
     */
    public void printLinkedListStack(Node head) {
        //判断参数
        if (head == null) {
            return;
        }

        //入栈
        Stack<Integer> stack = new Stack<>();
        Node next = head.next;
        while (next != null) {
            stack.push(next.data);
            next = next.next;
        }
        //出栈
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    /**
     * 重新构造新的链表，以便从头遍历
     *
     * @param head
     */
    public void printLinkedListByCreate(Node head) {
        //判断参数
        if (head == null) {
            return;
        }

        Node next = head.next;

        Node newHead = null;
        while (next != null) {
            Node newNode = new Node(next.data, null);
            if (newHead == null) {
                newHead = new Node(null, newNode);
            } else {
                Node temp = newHead.next;
                newNode.next = temp;
                newHead.next = newNode;
            }
            next = next.next;
        }
        Node n = newHead.next;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }


    public static void main(String[] args) {
        PrintListInRevesedOrder p = new PrintListInRevesedOrder();
        p.insertAtTail(5);
        p.insertAtTail(8);
        p.insertAtTail(9);
        p.insertAtHead(6);
        p.display();

        System.out.println();
        p.printLinkedListRecursive(p.head);

        System.out.println();

        p.printLinkedListStack(p.head);

        System.out.println();
        p.printLinkedListByCreate(p.head);

        System.out.println();
        p.display();
    }
}
