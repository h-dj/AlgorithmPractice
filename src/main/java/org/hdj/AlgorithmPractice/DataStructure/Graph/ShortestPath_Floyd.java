package org.hdj.AlgorithmPractice.DataStructure.Graph;

/**
 * @Auther: h_dj
 * @Date: 2019/2/4 16:35
 * @Description: floyd 算法
 * <p>
 */
public class ShortestPath_Floyd {

    public final static int INF = Integer.MAX_VALUE;

    public void floyd(MGraph G) {

        int vNum = G.getVexNum();

        //用于保存最短路径的前驱矩阵
        int[][] path = new int[vNum][vNum];
        //顶点到顶点之间最短权值和的矩阵
        int[][] dist = new int[vNum][vNum];

        // 初始化
        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < vNum; j++) {
                dist[i][j] = G.getArcs()[i][j];    // "顶点i"到"顶点j"的路径长度为"i到j的权值"。
                path[i][j] = j;                // "顶点i"到"顶点j"的最短路径是经过顶点j。
            }
        }

        // 计算最短路径
        for (int k = 0; k < vNum; k++) {
            for (int i = 0; i < vNum; i++) {
                for (int j = 0; j < vNum; j++) {
                    //获取顶点i到顶点k的距离 和顶点k到顶点j的距离，两顶距离相加
                    int tmp = (dist[i][k] == INF || dist[k][j] == INF) ? INF : (dist[i][k] + dist[k][j]);
                    //如果(顶点i-->顶点j)的距离 大于 (顶点i-->顶点k-->顶点j)的距离
                    //那么修改顶点i到顶点j的距离 为路径 i-->k-->j的距离
                    if (dist[i][j] > tmp) {
                        // "i到j最短路径"对应的值设，为更小的一个(即经过k)
                        dist[i][j] = tmp;
                        // "i到j最短路径"对应的路径，经过k
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

        // 打印floyd最短路径的结果
        System.out.printf("floyd: \n");
        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < vNum; j++)
                System.out.printf("%20d", dist[i][j]);
            System.out.printf("\n");
        }

        System.out.printf("floyd: \n");
        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < vNum; j++)
                System.out.printf("%10d", path[i][j]);
            System.out.printf("\n");
        }
    }
}
