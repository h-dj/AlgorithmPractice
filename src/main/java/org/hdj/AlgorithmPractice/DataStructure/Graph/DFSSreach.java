package org.hdj.AlgorithmPractice.DataStructure.Graph;

/**
 * @Auther: h_dj
 * @Date: 2019/3/29 13:03
 * @Description: 深度优先遍历
 *
 * n各顶点， e条边
 * 使用邻接矩阵的时间复杂度为O(n^2)
 * 使用邻接表的时间复杂度为O(e)
 */
public class DFSSreach {

    //访问标志数组
    private static boolean[] visited;

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
        System.out.print(g.getVex(vIndex).toString() + " ");
        int w = g.firstAdjVex(vIndex);
        while (w >= 0) {
            if (!visited[w])
                DFS(g, w); // 递归访问顶点v未访问的邻接点
            w = g.nextAdjVex(vIndex, w);
        }
    }
}
