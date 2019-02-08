package org.hdj.AlgorithmPractice.Graph.utils;

import org.hdj.AlgorithmPractice.Graph.MGraph;

/**
 * @Auther: h_dj
 * @Date: 2019/2/4 16:35
 * @Description: floyd 算法
 * <p>
 * https://www.cnblogs.com/skywang12345/p/3711532.html
 */
public class ShortestPath_FLOYD {

    public boolean[][][] P;
    public int[][] D;
    public final static int INFINITY = Integer.MAX_VALUE;

    public void FLOYD(MGraph G) {
        int vexNum = G.getVexNum();
        P = new boolean[vexNum][vexNum][vexNum];
        D = new int[vexNum][vexNum];

        for (int i = 0; i < vexNum; i++) {
            for (int j = 0; j < vexNum; j++) {
                D[i][j] = G.getArcs()[i][j];

                for (int k = 0; k < vexNum; k++) {
                    P[i][j][k] = false;
                }
                if (D[i][j] < INFINITY) {
                    //i 到 j有直接路径
                    P[i][j][i] = true;
                    P[i][j][j] = true;
                }
            }
        }


        for (int i = 0; i < vexNum; i++) {
            for (int j = 0; j < vexNum; j++) {
                for (int k = 0; k < vexNum; k++) {
                    if (D[j][i] < INFINITY && D[i][k] < INFINITY && (D[j][i] + D[i][k] < D[j][k])) {
                        D[j][k] = D[j][i] + D[i][k];

                        for (int l = 0; l < vexNum; l++) {
                            P[j][k][l] = P[j][i][l] || P[i][j][l];
                        }
                    }
                }
            }

        }
    }

}
