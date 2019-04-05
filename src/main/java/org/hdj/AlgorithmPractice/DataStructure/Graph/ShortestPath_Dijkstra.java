package org.hdj.AlgorithmPractice.DataStructure.Graph;

/**
 * @Auther: h_dj
 * @Date: 2019/2/2 23:08
 * @Description: 最短路径(Dijkstra 算法)
 */
public class ShortestPath_Dijkstra {


    public final static int INFINITY = Integer.MAX_VALUE;


    public void dijkstra(MGraph G, int startVex) {

        //顶点数
        int vNum = G.getVexNum();
        //用于保存开始顶点 startVex 到其它顶点i的最短距离
        int dist[] = new int[vNum];

        //如果sptSet[i] = true, 则顶点i 包含在最短路径中
        //如果全部为ture,则最短路径已完成
        Boolean sptSet[] = new Boolean[vNum];


        //初始化
        for (int i = 0; i < vNum; i++) {
            dist[i] = INFINITY;
            sptSet[i] = false;
        }


        //设置指定开始顶点到本身最短距离为0
        dist[startVex] = 0;

        for (int i = 0; i < vNum; i++) {
            //从未包含在最短路径顶点中 筛选最短距离的顶点
            //最小值
            int min = Integer.MAX_VALUE;
            //最小值下标
            int minIndex = -1;

            //找出顶点v到开始顶点startIndex 中的最短距离的顶点
            for (int v = 0; v < vNum; v++) {
                if (sptSet[v] == false && dist[v] <= min) {
                    min = dist[v];
                    minIndex = v;
                }
            }

            //标识该顶点包含在最短路径中
            sptSet[minIndex] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < vNum; j++) {
                int uj = G.getArcs()[minIndex][j];

                int tmp = (uj == INFINITY ? INFINITY : (dist[minIndex] + uj));
                if (sptSet[j] == false && tmp < dist[j]) {
                    dist[j] = tmp;
                }
            }
        }

        // 打印dijkstra最短路径的结果
        System.out.printf("dijkstra(%s): \n", G.getVex(startVex));
        for (int i = 0; i < vNum; i++)
            System.out.printf("  shortest(%s, %s)=%d\n", G.getVex(startVex), G.getVex(i), dist[i]);
    }


}
