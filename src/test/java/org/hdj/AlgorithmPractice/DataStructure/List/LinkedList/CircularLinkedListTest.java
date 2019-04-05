package org.hdj.AlgorithmPractice.DataStructure.List.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: h_dj
 * @Date: 2019/3/25 11:13
 * @Description:
 */
public class CircularLinkedListTest {

    CircularLinkedList<Integer> linkedList=new CircularLinkedList<>();
    @Before
    public void setUp() throws Exception {
        linkedList.insert(0,1);
        linkedList.insert(1,2);
        linkedList.insert(2,3);
    }

    @Test
    public void clear() throws Exception {
        linkedList.display();
        linkedList.clear();

        linkedList.display();
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(linkedList.isEmpty());
    }

    @Test
    public void size() throws Exception {
        System.out.println(
                linkedList.size()
        );
    }

    @Test
    public void get() throws Exception {
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(1));
    }

    @Test
    public void insert() throws Exception {

        linkedList.display();


        linkedList.insert(1,6);
        linkedList.display();

        linkedList.insert(linkedList.size(),8);
        linkedList.display();
    }

    @Test
    public void remove() throws Exception {

        linkedList.remove(0);


        linkedList.display();


    }

    @Test
    public void indexOf() throws Exception {
        System.out.println(linkedList.indexOf(2));
        System.out.println(linkedList.indexOf(3));
        System.out.println(linkedList.indexOf(1));
        System.out.println(linkedList.indexOf(6));
    }

    @Test
    public void display() throws Exception {
        linkedList.display();
    }

}