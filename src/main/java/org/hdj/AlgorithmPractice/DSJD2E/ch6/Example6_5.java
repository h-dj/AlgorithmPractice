package org.hdj.AlgorithmPractice.DSJD2E.ch6;


import org.hdj.AlgorithmPractice.DSJD2E.Graph.GraphKind;
import org.hdj.AlgorithmPractice.DSJD2E.Graph.MGraph;
import org.hdj.AlgorithmPractice.DSJD2E.Graph.utils.ShortestPath_FLOYD;

import java.util.Arrays;

/**
 * @Auther: h_dj
 * @Date: 2019/2/5 15:49
 * @Description:
 */
public class Example6_5 {

    public final static int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Object[] vexs = {"A", "B", "C", "D"};
        int[][] arcs = {
                {0, 15, 3, INFINITY},
                {10, 0, 2, INFINITY},
                {INFINITY, INFINITY, 0, 2},
                {INFINITY, 8, 4, 0}
        };

        MGraph G = new MGraph(GraphKind.UDG, 4, 7, vexs, arcs);

        ShortestPath_FLOYD floyd = new ShortestPath_FLOYD();
        floyd.FLOYD(G);

        System.out.println("各村之间最短路径：");
        Arrays.stream(floyd.D).forEach((d) -> {
            System.out.println(Arrays.toString(d));
        });

        findPlace(G, floyd.D);
    }

    private static void findPlace(MGraph g, int[][] d) {
        int min = INFINITY;
        int sum = 0;
        int u = -1;
        for (int i = 0; i < d.length; i++) {

            sum = 0;
            for (int j = 0; j < d.length; j++) {
                sum = sum + d[i][j];
            }
            if (min > sum) {
                min = sum;
                u = i;
            }
        }

        System.out.println("俱乐部应设置" + g.getVex(u) + " 村，其到各村的路径长度为：\n");
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[u][i] + "\t");
        }
        System.out.println();
    }
}
