package org.hdj.AlgorithmPractice.List;

import org.hdj.AlgorithmPractice.DSJD2E.List.SequentialList.SqList;
import org.junit.Before;
import org.junit.Test;

/**
 * 顺序表的测试
 */
public class SqListTest {

    private SqList<Integer> sqList=new SqList<>(10);
    @Before
    public void init(){
        sqList.insert(1);
        sqList.insert(2);
    }

    @Test
    public void testInsert(){
        sqList.display();
        System.out.println();

        sqList.insert(1,5);
        sqList.display();
    }

    @Test
    public void testGet(){
        //获取第一个元素
        System.out.println(sqList.get(1));
    }

    @Test
    public void testIndexOf(){
        System.out.println(sqList.indexOf(1));
        System.out.println(sqList.indexOf(3));
        System.out.println(sqList.indexOf(null));
        System.out.println(sqList.indexOf(2));
    }

    @Test
    public void testClear(){

        sqList.display();
        System.out.println(sqList.size());
        System.out.println();
        sqList.clear();
        sqList.display();
        System.out.println(sqList.size());

        System.out.println(sqList.isEmpty());
    }

    @Test
    public void testRemove(){
        sqList.remove(1);

        sqList.display();
        System.out.println(sqList.size());
    }
}
