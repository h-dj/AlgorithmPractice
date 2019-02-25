package org.hdj.AlgorithmPractice.DSJD2E.ch6;


import org.hdj.AlgorithmPractice.DSJD2E.Graph.GraphKind;
import org.hdj.AlgorithmPractice.DSJD2E.Graph.IGraph;
import org.hdj.AlgorithmPractice.DSJD2E.Graph.MGraph;
import org.hdj.AlgorithmPractice.DSJD2E.Queue.LinkQueue;

/**
 * @Auther: h_dj
 * @Date: 2019/1/30 16:51
 * @Description: 获取无向图的连通分量
 *
 * 若图非无向图，则无法获取图的全部顶点，而只能访问连通图的所有顶点
 */
public class Example6_1 {

    public final static int INFINITY = Integer.MAX_VALUE;

    public static void CC_BFS(IGraph graph) {
        //顶点已访问标识数组
        int vexNum = graph.getVexNum();
        boolean[] visited = new boolean[vexNum];
        for (int i = 0; i < vexNum; i++) {
            //初始化数组
            visited[i] = false;
        }

        LinkQueue q = new LinkQueue<>();
        LinkQueue p = new LinkQueue<>();//记录连通分量的顶点
        //记录连通分量的个数
        int count = 0;
        for (int i = 0; i < vexNum; i++) {
            p.clear();
            if (!visited[i]) {
                visited[i] = true;
                p.offer(graph.getVex(i));
                q.offer(i);

                while (!q.isEmpty()) {
                    int u = (int) q.poll();

                    int w = graph.firstAdjVex(u);
                    while (w >= 0) {
                        if (!visited[w]) {
                            visited[w] = true;
                            p.offer(graph.getVex(w));
                            q.offer(w);
                        }
                         w= graph.nextAdjVex(u,w);
                    }
                }

                System.out.println("图的第" + (++count) + "个连通分量为：");
                while (!p.isEmpty()) {
                    System.out.print(p.poll());
                }
                System.out.println();
            }
        }


    }


    public static void main(String[] args) {
        Object vexs[] = {"A", "B", "C", "D", "E", "F", "G"};

        int[][] arcs = {
                {0, 1, INFINITY, 1, INFINITY, INFINITY, INFINITY},
                {1, 0, 1, INFINITY, INFINITY, INFINITY, INFINITY},
                {INFINITY, 1, 0, 1, INFINITY, INFINITY, INFINITY},
                {1, INFINITY, 1, 0, INFINITY, INFINITY, INFINITY},
                {INFINITY, INFINITY, INFINITY, INFINITY, 0, 1, INFINITY},
                {INFINITY, INFINITY, INFINITY, INFINITY, 1, 0, 1},
                {INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 1, 0},
        };

        MGraph g = new MGraph(GraphKind.UDG, 7, 6, vexs, arcs);
        CC_BFS(g);
    }
}
