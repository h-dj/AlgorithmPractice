package org.hdj.AlgorithmPractice.DataStructure.Search;

import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: h_dj
 * @Date: 2019/2/19 14:56
 * @Description:
 */
public class BinarySearchTest {

    int[] elements;


    @Before
    public void setUp() throws Exception {
        elements = new int[]{1,2,3,4,5,6};
    }


    @Test
    public void binarySearch() throws Exception {
        BinarySearch binarySearch=new BinarySearch();
        int i = binarySearch.binarySearch(elements, 3);
        System.out.println(i);
    }

}