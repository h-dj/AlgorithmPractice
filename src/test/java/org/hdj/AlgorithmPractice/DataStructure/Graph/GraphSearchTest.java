package org.hdj.AlgorithmPractice.DataStructure.Graph;

import org.junit.Test;

/**
 * @Auther: h_dj
 * @Date: 2019/3/29 13:06
 * @Description: 图遍历测试
 */
public class GraphSearchTest {
    public final static int INFINITY = Integer.MAX_VALUE;
    Object vexs[] = {"v0", "v1", "v2", "v3", "v4", "v5", "v6", "v7"};

    int[][] arcs = {
            {0, 10, 8, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY},
            {10, 0, INFINITY, 20, 2, INFINITY, INFINITY, INFINITY},
            {5, INFINITY, 0, INFINITY, INFINITY, 7, 30, INFINITY},
            {INFINITY, 20, INFINITY, 0, INFINITY, INFINITY, INFINITY, 1},
            {INFINITY, 2, INFINITY, INFINITY, 0, INFINITY, INFINITY, 3},
            {INFINITY, INFINITY, 40, INFINITY, INFINITY, 0, 6, INFINITY},
            {INFINITY, INFINITY, 35, INFINITY, INFINITY, 45, 0, INFINITY},
            {INFINITY, INFINITY, INFINITY, 11, 15, INFINITY, INFINITY, 0},

    };


    @Test
    public void DFSTraverse() throws Exception {
        DFSSreach.DFSTraverse(new MGraph(GraphKind.UDG, vexs.length, arcs.length, vexs, arcs));
    }

    @Test
    public void BFSTraverse() throws Exception {
        BFSSreach.BFSTraverse(new MGraph(GraphKind.UDG, vexs.length, arcs.length, vexs, arcs));
    }


}