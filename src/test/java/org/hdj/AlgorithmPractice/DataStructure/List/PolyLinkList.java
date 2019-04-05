package org.hdj.AlgorithmPractice.DataStructure.List;


import org.hdj.AlgorithmPractice.DataStructure.List.LinkedList.LNode;
import org.hdj.AlgorithmPractice.DataStructure.List.LinkedList.LinkedList;
import org.hdj.AlgorithmPractice.DataStructure.ch2.polynomail.PolyNode;

import java.util.Scanner;

/**
 * @Auther: h_dj
 * @Date: 2019/2/27 22:30
 * @Description: 一元多项式相加
 */
public class PolyLinkList extends LinkedList<PolyNode> {


    public PolyLinkList(int n) {
        head.data = new PolyNode(0, -1);
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            double coef = in.nextDouble(); //系数
            int expn = in.nextInt();//指数

            insert(new PolyNode(coef, expn));
        }
    }

    /**
     * 插入结点
     * <p>
     * 必须保持项式的按指数有序性排列
     *
     * @param node
     */
    public void insert(PolyNode node) {

        //获取第一个结点
        LNode<PolyNode> next = head.next;
        //插入的位置
        int i = -1;
        while (next != null) {
            if (next.data.expn > node.expn) {
                break;
            }
            i++;
            next = next.next;
        }
        //判断插入的位置是否合法
        if (i < 0 || i > size() - 1)
            throw new RuntimeException("插入异常");
        //插入
        insert(i, node);
    }


    /**
     * 比较两个项式
     *
     * @param a
     * @param b
     * @return
     */
    public int compare(PolyNode a, PolyNode b) {
        if (a.expn == b.expn) {
            return 0;
        } else if (a.expn > b.expn) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * 相加两个一元多项式
     *
     * @param LA
     * @param LB
     * @return
     */
    public PolyLinkList applyPoly(PolyLinkList LA, PolyLinkList LB) {
        LNode<PolyNode> ha = LA.head;

        LNode<PolyNode> qa = LA.head.next;
        LNode<PolyNode> qb = LB.head.next;

        while (qa != null && qb != null) {
            //判断项式的指数
            int compare = compare(qa.data, qb.data);
            switch (compare) {
                case 1:
                    //如果LB的项式指数小于LA的项式指数
                    //则把LB的项式加入新链表
                    ha.next = qb;
                    ha = qb;

                    qb = qb.next;
                    break;
                case 0:
                    //如果两个项式，指数相等，则相加系数，合并两个项式
                    double coefA = qa.data.coef;
                    double coefB = qb.data.coef;

                    double sum = coefA + coefB;
                    //如果系数相加为零，则丢弃这个项式
                    if (sum != 0) {
                        //创建新的结点
                        qa.data.coef = sum;
                        ha.next = qa;
                        ha = qa;
                    }
                    qa = qa.next;
                    qb = qb.next;
                    break;
                case -1:
                    //如果LA的项式指数小于LA的项式指数
                    //则把LA的项式加入新链表
                    ha.next = qa;
                    ha = qa;

                    qa = qa.next;
                    break;
            }

            //将剩余的项式加入新的链表
            qa = qa != null ? qa : qb;

            ha.next = qa;
        }
        return LA;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入A多项式的项数");
        int m = in.nextInt();
        System.out.print("请输入 多项式A 各项的系数和指数");
        PolyLinkList LA = new PolyLinkList(m);

        System.out.print("请输入B多项式的项数");

        int n = in.nextInt();
        System.out.print("请输入 多项式B 各项的系数和指数");
        PolyLinkList LB = new PolyLinkList(n);

        LA = LA.applyPoly(LA, LB);
        System.out.println("求和后的个项式");
        LA.display();

    }
}
