package org.hdj.AlgorithmPractice.DataStructureJavaDescribe2Edition.ch2;

import org.hdj.AlgorithmPractice.Lcs;
import org.hdj.AlgorithmPractice.List.LinkedList.LNode;
import org.hdj.AlgorithmPractice.List.LinkedList.LinkedList;

/**
 * 合并两个链表，按非递减排序
 */
public class Demo2_5 {
    private LinkedList<Integer> La = new LinkedList<>();
    private LinkedList<Integer> Lb = new LinkedList<>();

    {
        La.insertAtHead(1);
        La.insertAtHead(3);
        La.insertAtHead(5);

        Lb.insertAtHead(0);
        Lb.insertAtHead(5);
        Lb.insertAtHead(7);
    }

    public LinkedList<Integer> mergeLinkedList(LinkedList<Integer> La, LinkedList<Integer> Lb) {

        LNode pa = La.head;
        LNode pb = Lb.head;
        LNode pc = La.head;

        while (pa != null && pb != null) {
            Integer pAdata = (Integer) pa.data;
            Integer pBdata = (Integer) pb.data;

            if (pAdata <= pBdata) {
                pc.next = pa;
                pc = pa;
                pa = pa.next;
            } else {
                pc.next = pb;
                pc = pb;
                pb = pb.next;
            }
        }

        pc.next = pa == null ? pb : pa;

        return La;
    }

}
