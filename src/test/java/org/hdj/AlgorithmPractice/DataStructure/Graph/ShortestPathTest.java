package org.hdj.AlgorithmPractice.DataStructure.Graph;

import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: h_dj
 * @Date: 2019/2/4 13:51
 * @Description:
 */
public class ShortestPathTest {
    private Object[] vexs;
    public int[][] arcs;
    public MGraph G;
    private final static int INFINITY = Integer.MAX_VALUE;

    @Before
    public void init() {
        vexs = new Object[]{"v0", "v1", "v2", "v3", "v4", "v5"};

        arcs = new int[][]{
                {0, INFINITY, 10, INFINITY, 30, 100},
                {INFINITY, 0, 5, INFINITY, INFINITY, INFINITY},
                {INFINITY, INFINITY, 0, 50, INFINITY, INFINITY},
                {INFINITY, INFINITY, INFINITY, 0, INFINITY, 10},
                {INFINITY, INFINITY, INFINITY, 20, 0, 60},
                {INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 0}
        };

        G = new MGraph(GraphKind.DG, 6, 10, vexs, arcs);

    }


    @Test
    public void DIJ() throws Exception {
        ShortestPath_Dijkstra dij = new ShortestPath_Dijkstra();
        dij.dijkstra(G, 2);
    }



    @Test
    public void floyd(){

        ShortestPath_Floyd floyd=new ShortestPath_Floyd();
        floyd.floyd(G);
    }
}