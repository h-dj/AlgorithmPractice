package org.hdj.AlgorithmPractice.DataStructure.Graph;


/**
 * @Auther: h_dj
 * @Date: 2019/2/1 16:39
 * @Description: 最小生成树--PRIM算法
 */
public class MinSpanningTree_Prim {
    /**
     * 用于记录权值最小的边
     */
    class CloseEdge {
        //邻接点值
        Object adjVex;
        //最小权值
        int lowCost;

        public CloseEdge(Object adjVex, int lowCost) {
            this.adjVex = adjVex;
            this.lowCost = lowCost;
        }
    }
    /**
     * Prim 算法
     *
     * @param G 图的邻接矩阵
     * @param u 顶点u
     * @return
     */
    public Object[][] PRIM(MGraph G, Object u) {
        // 定义最小生成树
        Object[][] tree = new Object[G.getVexNum() - 1][2];
        //记录已构造生成树顶点的个数
        int count = 0;
        //图的边集
        CloseEdge[] closeEdges = new CloseEdge[G.getVexNum()];
        //获取顶点u的位置
        int k = G.locateVex(u);
        //辅助数组初始化
        for (int i = 0; i < G.getVexNum(); i++) {
            if (i != k)
                //与顶点u相连的边，存入数组
                closeEdges[i] = new CloseEdge(u, G.getArcs()[k][i]);
        }
        //初始化集合U = {u}
        closeEdges[k] = new CloseEdge(u, 0);
        for (int i = 1; i < G.getVexNum(); i++) {

            //获取权值最小边相连的邻接点
            k = getMinMum(closeEdges);
            //生成树的边放入数组中
            tree[count][0] = closeEdges[k].adjVex;
            tree[count][1] = G.getVexs()[k];
            //生成树顶点个数加一
            count++;
            //第k个顶点放入U集
            closeEdges[k].lowCost = 0;

            //重新筛选权值最小的边
            for (int j = 0; j < G.getVexNum(); j++) {
                if (G.getArcs()[k][j] < closeEdges[j].lowCost) {
                    //与顶点k相连的边，存入数组
                    closeEdges[j] = new CloseEdge(G.getVex(k), G.getArcs()[k][j]);
                }
            }
        }
        return tree;
    }

    /**
     * 选出边权值最小的邻接点
     *
     * @param closeEdges
     * @return
     */
    private int getMinMum(CloseEdge[] closeEdges) {
        int min = Integer.MAX_VALUE;
        int v = -1;
        for (int i = 0; i < closeEdges.length; i++) {
            if (closeEdges[i].lowCost != 0 && closeEdges[i].lowCost < min) {
                min = closeEdges[i].lowCost;
                v = i;
            }
        }
        return v;
    }

}
