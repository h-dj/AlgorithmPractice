package org.hdj.AlgorithmPractice.DataStructure.ch2.polynomail;


import org.hdj.AlgorithmPractice.DataStructure.List.LinkedList.LNode;
import org.hdj.AlgorithmPractice.DataStructure.List.LinkedList.LinkedList;

import java.util.Scanner;

/**
 * 多项式相加链表
 * <p>
 * 请输入A多项式的项数
 * 5
 * 请输入 多项式A 各项的系数和指数
 * 3 0
 * 4 1
 * 7 8
 * 2 18
 * 1 30
 * 请输入B多项式的项数
 * 3
 * 请输入 多项式B 各项的系数和指数
 * 5 1
 * 6 3
 * -7 8
 * 求和后的个项式
 * 系数：3.0 指数：0
 * 系数：9.0 指数：1
 * 系数：6.0 指数：3
 * 系数：2.0 指数：18
 * 系数：1.0 指数：30
 */
public class PolyLinkedList extends LinkedList<PolyNode> {


    //创建多项式有序链表
    public PolyLinkedList(int n) {
        head.data = new PolyNode(0, -1);
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            double coef = in.nextDouble(); //系数
            int expn = in.nextInt();//指数

            insert(new PolyNode(coef, expn));
        }
    }

    /**
     * 有序插入
     *
     * @param polyNode
     */
    public void insert(PolyNode polyNode) {
        int j = 0;
        while (j < size()) {
            PolyNode node = get(j);
            //与链表中的已有的项式进行指数比较
            if (node.expn > polyNode.expn)
                break;
            j++;
        }
        insert(j, polyNode);
    }

    /**
     * 项式比较函数
     *
     * @param a
     * @param b
     * @return
     */
    public int compare(PolyNode a, PolyNode b) {
        if (a.expn < b.expn) {
            return -1;
        } else if (a.expn == b.expn) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 两个多项式相加
     *
     * @param LA
     * @param LB
     * @return
     */
    public PolyLinkedList addPoly(PolyLinkedList LA, PolyLinkedList LB) {
        //ha  将LA的头节点作为新生成链表的尾节点
        LNode<PolyNode> ha = LA.head;
        // qa 指向LA 需要计算的当前项
        LNode<PolyNode> qa = LA.head.next;
        // qb 指向LB 需要计算的当前项
        LNode<PolyNode> qb = LB.head.next;
        //计算的项都不为空，继续计算，否则退出
        while (qa != null && qb != null) {
            //获取多项式LA当前项的数据域
            PolyNode a = qa.data;
            //获取多项式LB当前项的数据域
            PolyNode b = qb.data;

            // 比较两个多项式当前项的指数
            switch (compare(a, b)) {
                case -1:
                    //如果多项式LA中当前节点的指数值小
                    //生成新链表的尾指针指向 LA当前节点
                    ha.next = qa;
                    // 新链表的尾节点变为 LA当前节点
                    ha = qa;
                    //继续LA下一个节点的计算
                    qa = qa.next;
                    break;
                case 0:
                    //如果两者指数相等
                    //获取LA 和LB 当前节点数据域中的系数和
                    double sum = a.coef + b.coef; //系数和

                    //如果系数和不为零
                    if (sum != 0.0) {
                        //把LA 当前节点系数赋值为系数和
                        a.coef = sum;
                        //把LA 当前节点 作为新链表节点
                        ha.next = qa;
                        ha = qa;
                        // 继续 LA 和LB 下一个节点计算
                        qa = qa.next;
                        qb = qb.next;
                    } else {
                        //如果系数和为零，抛弃当前节点，继续 LA 和LB 下一个节点计算
                        qa = qa.next;
                        qb = qb.next;
                    }
                    break;
                case 1:
                    //如果多项式LB中当前节点的指数值小
                    //生成新链表的尾指针指向 LB当前节点
                    ha.next = qb;
                    // 新链表的尾节点变为 LB当前节点
                    ha = qb;
                    qb = qb.next;
                    break;
            }
        }
        // 判断哪个链表还有节点，直接将新链表的尾指针指向该节点
        ha.next = (qa != null ? qa : qb);
        return LA;
    }

    @Override
    public void display() {
        for (int i = 0; i < size(); i++) {
            PolyNode node = get(i);
            System.out.println("系数：" + node.coef + " 指数：" + node.expn);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入A多项式的项数");
        int m = in.nextInt();
        System.out.print("请输入 多项式A 各项的系数和指数");
        PolyLinkedList LA = new PolyLinkedList(m);

        System.out.print("请输入B多项式的项数");

        int n = in.nextInt();
        System.out.print("请输入 多项式B 各项的系数和指数");
        PolyLinkedList LB = new PolyLinkedList(n);

        LA = LA.addPoly(LA, LB);
        System.out.println("求和后的个项式");
        LA.display();

    }
}
