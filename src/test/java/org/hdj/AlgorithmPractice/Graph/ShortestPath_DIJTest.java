package org.hdj.AlgorithmPractice.Graph;

import org.hdj.AlgorithmPractice.DSJD2E.Graph.GraphKind;
import org.hdj.AlgorithmPractice.DSJD2E.Graph.MGraph;
import org.hdj.AlgorithmPractice.DSJD2E.Graph.utils.ShortestPath_DIJ;
import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: h_dj
 * @Date: 2019/2/4 13:51
 * @Description:
 */
public class ShortestPath_DIJTest {
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

        G = new MGraph(GraphKind.UDG, 6, 10, vexs, arcs);

    }


    @Test
    public void DIJ() throws Exception {
        ShortestPath_DIJ dij = new ShortestPath_DIJ();
        dij.DIJ(G, 0);
    }

}