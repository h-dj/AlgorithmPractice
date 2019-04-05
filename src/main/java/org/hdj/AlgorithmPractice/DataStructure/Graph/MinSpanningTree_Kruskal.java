package org.hdj.AlgorithmPractice.DataStructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: h_dj
 * @Date: 2019/3/29 16:05
 * @Description: 最小生成树 -- Kruskal算法 (大话数据结构)
 */
public class MinSpanningTree_Kruskal {

    //边
    class Edge implements Comparable<Edge> {

        int src, //边的开始顶点位置
                dest,//边的目标顶点位置
                weight;//权值

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }


        @Override
        public String toString() {
            return "\nEdge{" +
                    "src=" + src +
                    ", dest=" + dest +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }


    public List<Edge> kruskal(MGraph G) {


        int vNum = G.getVexNum();//顶点数
        int eNum = G.getArcNum();//边数
        Edge edge[] = new Edge[eNum];//边的集合
        int[] parent = new int[vNum];// 用于保存"已有最小生成树"中每个顶点在该最小树中的终点。
        //最小生成树 MST 的边集合
        List<Edge> mst = new ArrayList<>();

        //转化矩阵为边集数组
        int index = 0;
        for (int src = 0; src < vNum; src++) {
            for (int dest = src; dest < vNum; dest++) {
                int weight = G.getArcs()[src][dest];
                if (weight > 0 && weight < MGraph.INFINITY) {
                    edge[index] = new Edge(src, dest, G.getArcs()[src][dest]);
                    index++;
                }
            }
        }
        //把边集数组按权值从小到大排序
        Arrays.sort(edge);

        //初始化
        for (int i = 0; i < vNum; i++) {
            parent[i] = 0;
        }
        //循环每一条边
        for (int i = 0; i < eNum; i++) {

            int n = find(parent, edge[i].src);
            int m = find(parent, edge[i].dest);
            //所选的边没有生成回路
            if (n != m) {
                //记录已纳入mst中的顶点
                parent[n] = m;
                //加入MST中
                mst.add(edge[i]);
            }
        }
        return mst;
    }

    /**
     * 查找连线顶点的尾部下标
     *
     * @param parent
     * @param f      权值最小边的尾顶点下标
     * @return
     */
    private int find(int[] parent, int f) {
        while (parent[f] > 0)
            f = parent[f];
        return f;
    }

}
