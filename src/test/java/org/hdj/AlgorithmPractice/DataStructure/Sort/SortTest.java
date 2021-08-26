package org.hdj.AlgorithmPractice.DataStructure.Sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: h_dj
 * @Date: 2019/2/13 16:46
 * @Description: 排序测试
 */
public class SortTest {

    int[] elements;


    @Before
    public void setUp() throws Exception {
        elements = new int[]{52, 39, 67, 70, 8, 95, 25, 26};
    }


    @Test
    public void straightSelectionSortTest() {
        DirectSelectionSort.straightSelectionSort(elements);

        System.out.println(Arrays.toString(elements));
    }


    @Test
    public void treeSelectionSort() {
        TreeSelectionSort selectionSort = new TreeSelectionSort();

        selectionSort.treeSelectionSort(elements);

        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void headSort() {
        HeadSort.headSort(elements);

        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void mergeSort() {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(elements);

        System.out.println(Arrays.toString(elements));
    }

    @Test
    public void quickSort() {
        elements = new int[]{2, 4, 6, 8, 1};
        QuickSort.qSort(elements, 0, elements.length - 1);
        System.out.println(Arrays.toString(elements));


    }
}