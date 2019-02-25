package org.hdj.AlgorithmPractice.DSJD2E.Graph.utils;

import org.hdj.AlgorithmPractice.DSJD2E.Graph.MGraph;

import java.util.Arrays;

/**
 * @Auther: h_dj
 * @Date: 2019/2/2 23:08
 * @Description: 最短路径(Dijkstra 算法)
 */
public class ShortestPath_DIJ {

    //v0到其余顶点的最短路径序列位置标识
    public boolean[][] P;
    //v0到其余顶点的带权长度
    public int[] D;

    public final static int INFINITY = Integer.MAX_VALUE;

    /**
     * @param G
     * @param v0
     */
    public void DIJ(MGraph G, int v0) {
        //顶点个数
        int vexNum = G.getVexNum();
        P = new boolean[vexNum][vexNum];
        // 源顶点v0到个顶点的最短距离
        D = new int[vexNum];

        //用于标识源顶点v0 到目标顶点vi是否已求得最短路径,是为true
        boolean[] finish = new boolean[vexNum];
        //初始化
        for (int i = 0; i < vexNum; i++) {
            //初始化未知顶点的最短路径状态
            finish[i] = false;
            //初始化顶点v0相连顶点边的权值
            D[i] = G.getArcs()[v0][i];

            //置空路径
            for (int j = 0; j < vexNum; j++) {
                P[i][j] = false;

                if (D[i] < INFINITY) {
                    P[i][v0] = true;
                    P[i][i] = true;
                }
            }
        }

        Arrays.stream(P).forEach((p) -> {
            System.out.println(Arrays.toString(p));
        });

        //初始化，顶点v0属于S集；S的作用是记录已求出最短路径的顶点
        D[v0] = 0;
        //标记顶点v0已经得到最短路径
        finish[v0] = true;

        int v = 0;
        for (int i = 1; i < vexNum; i++) {

            //寻找当前最小的路径；
            // 在未获取最短路径的顶点中，找到离v0最近的顶点(v)。
            int min = INFINITY;
            for (int j = 0; j < vexNum; j++) {
                if (!finish[j]) {
                    if (D[j] < min) {
                        v = j;
                        min = D[j];
                    }
                }
            }

            //标识"顶点v" 已找到最短路径
            finish[v] = true;

            //更新 未获取最短路径的顶点的最短路径
            for (int w = 1; w < vexNum; w++) {
                //如果是未获得最短路径
                //而且比较 (min + G.getArcs()[v][j]) < D[j]， 更新顶点到各个顶点的最短路径
                //如：当w=3，v=2 ,min=10(顶点v0 到顶点v的权值); 顶点v0到顶点v3的权值为 INFINITY (D[3]), 顶点v 到顶点v3的权值为50
                //则(min + G.getArcs()[2][3]) = 10+50=60 < D[3] = INFINITY
                //所以： D[3] = 60
                if (!finish[w] && G.getArcs()[v][w] < INFINITY && (min + G.getArcs()[v][w]) < D[w]) {
                    D[w] = min + G.getArcs()[v][w];


                    System.arraycopy(P[v], 0, P[w], 0, P[v].length);
                    P[w][w] = true;
                }
            }

        }
        System.out.println();

        Arrays.stream(P).forEach((p) -> {
            System.out.println(Arrays.toString(p));
        });
    }
}
