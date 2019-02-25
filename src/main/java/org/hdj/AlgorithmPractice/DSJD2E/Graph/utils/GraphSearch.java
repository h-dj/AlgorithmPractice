package org.hdj.AlgorithmPractice.DSJD2E.Graph.utils;

import org.hdj.AlgorithmPractice.DSJD2E.Graph.IGraph;
import org.hdj.AlgorithmPractice.DSJD2E.Queue.LinkQueue;

/**
 * @Auther: h_dj
 * @Date: 2019/1/30 16:08
 * @Description: 图辅助工具
 */
public class GraphSearch {

    //访问标志数组
    private static boolean[] visited;

    /**
     * 广度优先遍历
     *
     * @param G
     */
    public static void BFSTraverse(IGraph G) {
        //图的顶点数
        int vexNum = G.getVexNum();
        // 初始化访问标记数组
        visited = new boolean[vexNum];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < vexNum; i++) {
            //如果该顶点未遍历，则进行广度优先遍历
            if (!visited[i]) {
                BFS(G, i);
            }
        }


    }

    /**
     * 广度优先遍历算法
     *
     * @param g
     * @param vexIndex
     */
    private static void BFS(IGraph g, int vexIndex) {
        // 先标记该顶点已访问
        visited[vexIndex] = true;

        //打印顶点
        System.out.println(g.getVex(vexIndex).toString());

        //初始化队列，用于保存该顶点的邻接点
        LinkQueue<Integer> queue = new LinkQueue();
        queue.offer(vexIndex);
        while (!queue.isEmpty()) {
            //出队列
            int poll = queue.poll();
            //获取该顶点的第一个邻接点索引
            int w = g.firstAdjVex(poll);
            while (w >= 0) {
                //如果未访问
                if (!visited[w]) {
                    //标志已访问
                    visited[w] = true;
                    //访问索引为w的顶点
                    System.out.println(g.getVex(w).toString());
                    queue.offer(w);
                    //下一个邻接点
                    w = g.nextAdjVex(poll, w);
                }

            }
        }

    }

    /**
     * 深度优先遍历
     */
    public static void DFSTraverse(IGraph G) {
        //图的顶点数
        int vexNum = G.getVexNum();
        // 初始化访问标记数组
        visited = new boolean[vexNum];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < vexNum; i++) {
            //如果该顶点未遍历，则进行广度优先遍历
            if (!visited[i]) {
                DFS(G, i);
            }
        }


    }

    /**
     * 深度优先遍历算法
     *
     * @param g
     * @param vIndex
     */
    private static void DFS(IGraph g, int vIndex) {
        //标记当前顶点已访问
        visited[vIndex] = true;
        System.out.println(g.getVex(vIndex).toString());

        int w = g.firstAdjVex(vIndex);
        while (w >= 0) {
            if (!visited[w])
                DFS(g, w); // 递归访问顶点v未访问的邻接点
            w = g.nextAdjVex(vIndex, w);
        }
    }

}
