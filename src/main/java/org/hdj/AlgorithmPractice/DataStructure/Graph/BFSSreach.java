package org.hdj.AlgorithmPractice.DataStructure.Graph;

import org.hdj.AlgorithmPractice.DataStructure.Queue.LinkQueue;

/**
 * @Auther: h_dj
 * @Date: 2019/3/29 12:59
 * @Description: 广度优先遍历
 * n各顶点， e条边
 * 使用邻接矩阵的时间复杂度为O(n^2)
 * 使用邻接表的时间复杂度为O(e)
 */
public class BFSSreach {

    //访问标志数组
    private static boolean[] visited;

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
     */
    private static void BFS(IGraph g, int vexIndex) {
        // 先标记该顶点已访问
        visited[vexIndex] = true;
        //打印顶点
        System.out.print(g.getVex(vexIndex) + " ");
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
                    System.out.print(g.getVex(w).toString() + " ");
                    queue.offer(w);
                }
                //下一个邻接点
                w = g.nextAdjVex(poll, w);
            }
        }

    }

}
