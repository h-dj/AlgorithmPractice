package org.hdj.AlgorithmPractice.DSJD2E.List.LinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: h_dj
 * @Date: 2019/3/25 16:47
 * @Description:
 */
public class DoublyLinkListTest {

    DoublyLinkList<Integer> linkList=new DoublyLinkList<>();

    @Before
    public void setUp() throws Exception {
        linkList.insert(0,1);
        linkList.insert(1,2);
        linkList.insert(2,3);
    }

    @Test
    public void clear() throws Exception {
        linkList.display();
    }

    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void size() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void insert() throws Exception {



        linkList.insert(1,5);
        linkList.display();

        linkList.insert(4,100);
        linkList.display();
    }

    @Test
    public void remove() throws Exception {

        Integer remove = linkList.remove(1);
        System.out.println(remove);


        Integer remove2 = linkList.remove(0);
        System.out.println(remove2);




    }

    @Test
    public void indexOf() throws Exception {

        System.out.println(linkList.indexOf(0));
        System.out.println(linkList.indexOf(1));
        System.out.println(linkList.indexOf(2));
        System.out.println(linkList.indexOf(6));
    }

    @Test
    public void display() throws Exception {
    }

}