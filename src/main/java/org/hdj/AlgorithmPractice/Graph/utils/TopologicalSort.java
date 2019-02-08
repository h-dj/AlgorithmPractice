package org.hdj.AlgorithmPractice.Graph.utils;

import org.hdj.AlgorithmPractice.Graph.ALGraph;
import org.hdj.AlgorithmPractice.Graph.ArcNode;
import org.hdj.AlgorithmPractice.Stack.LinkStack.LinkStack;

/**
 * @Auther: h_dj
 * @Date: 2019/2/5 16:39
 * @Description: 拓扑排序
 */
public class TopologicalSort {


    /**
     * 各顶点入度算法
     *
     * @param G
     * @return
     */
    public static int[] findInDegree(ALGraph G) {
        int[] indegree = new int[G.getVexNum()];

        for (int i = 0; i < G.getVexNum(); i++) {
            ArcNode node = G.getVexs()[i].firstArc;
            while (node != null) {
                //入度加一
                ++indegree[node.adjVex];
                node = node.nextArc;
            }
        }
        return indegree;
    }

    /**
     * 拓扑排序
     *
     * @return
     */
    public static boolean topLogicalSort(ALGraph graph) {
        //输出顶点计数
        int count = 0;
        //求顶点入度
        int[] indegree = findInDegree(graph);
        //创建入度为零的顶点栈
        LinkStack s = new LinkStack();

        //入度为0的进栈
        for (int i = 0; i < graph.getVexNum(); i++)
            if (indegree[i] == 0)
                s.push(i);


        while (!s.isEmpty()) {
            //出栈
            int pop = (int) s.pop();
            //输出顶点，计数
            System.out.println(pop);
            count++;

            //删除顶点，以及出发弧
            ArcNode node = graph.getVexs()[pop].firstArc;
            while (node != null) {
                //获取弧指向的顶点
                int adjVex = node.adjVex;
                //入度减一，如果是入度为零，则压入栈中
                if (--indegree[adjVex] == 0) {
                    s.push(adjVex);
                }
                node = node.nextArc;
            }
        }
        //判断是否有回路
        if (count < graph.getVexNum()) {
            return false;
        }
        return true;
    }
}
