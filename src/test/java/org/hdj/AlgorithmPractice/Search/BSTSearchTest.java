package org.hdj.AlgorithmPractice.Search;

import org.hdj.AlgorithmPractice.DSJD2E.Search.BSTree;
import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: h_dj
 * @Date: 2019/2/25 10:31
 * @Description:
 */
public class BSTSearchTest {

    private BSTree bstSearch = new BSTree();
    int[] k = {50, 13, 63, 8, 36, 90, 5, 10, 18, 70};

    @Before
    public void init(){
        for (int i = 0; i < k.length; i++) {
            bstSearch.insertBST(k[i]);
        }
    }

    @Test
    public void searchBST() throws Exception {
        Object o = bstSearch.searchBST(-2);
        System.out.println(o);
    }

    @Test
    public void insertBST() throws Exception {
        bstSearch.inOrderTraverse(bstSearch.root);

    }

    @Test
    public void removeBST() throws Exception {
        bstSearch.inOrderTraverse(bstSearch.root);
        bstSearch.removeBST(50);
        System.out.println();
        bstSearch.inOrderTraverse(bstSearch.root);
    }

}