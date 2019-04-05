package org.hdj.AlgorithmPractice.DataStructure.Graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


/**
 * @Auther: h_dj
 * @Date: 2019/3/29 18:54
 * @Description:
 */
public class MinSpanningTreeTest {

    public final static int INFINITY = Integer.MAX_VALUE;
    Object[] vexs = {"v0", "v1", "v2", "v3", "v4", "v5"};

    int[][] arcs = {
            {INFINITY, 7, 1, 5, INFINITY, INFINITY},
            {7, INFINITY, 6, INFINITY, 3, INFINITY},
            {1, 6, INFINITY, 7, 6, 4},
            {5, INFINITY, 7, INFINITY, INFINITY, 2},
            {INFINITY, 3, 6, INFINITY, INFINITY, 7},
            {INFINITY, INFINITY, 4, 2, 7, INFINITY},
    };

    MGraph G = new MGraph(GraphKind.UDG, 6, 10, vexs, arcs);

    @Test
    public void kruskal() throws Exception {
        MinSpanningTree_Kruskal kruskal = new MinSpanningTree_Kruskal();
        List<MinSpanningTree_Kruskal.Edge> kruskal1 = kruskal.kruskal(G);
        System.out.println(Arrays.toString(kruskal1.toArray()));

    }


    @Test
    public void prim() {
        MinSpanningTree_Prim prim = new MinSpanningTree_Prim();
        Object[][] tree = prim.PRIM(G, "v0");
        for (int i = 0; i < tree.length; i++) {
            System.out.println(tree[i][0] + "===" + tree[i][1]);
        }
    }
}