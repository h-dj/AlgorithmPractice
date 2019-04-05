package org.hdj.AlgorithmPractice.DataStructure.Graph;

import org.hdj.AlgorithmPractice.DataStructure.Stack.LinkStack.LinkStack;

/**
 * @Auther: h_dj
 * @Date: 2019/2/7 18:39
 * @Description: 关键路径
 */
public class CriticalPath {

    //拓扑逆序序列栈
    private LinkStack T = new LinkStack();

    //各顶点最早发生时间和最晚发生时间
    private int[] ee, le;

    /**
     * 拓扑序列，且函数返回true,否则返回false
     *
     * @param graph
     * @return
     */
    public boolean topologicalOrder(ALGraph graph) {
        //输出顶点计数
        int count = 0;
        //各个顶点入度
        int[] indegrees = TopologicalSort.findInDegree(graph);
        //零入度顶点栈
        LinkStack stack = new LinkStack();
        //入度为0的进栈
        for (int i = 0; i < graph.getVexNum(); i++)
            if (indegrees[i] == 0)
                stack.push(i);

        ee = new int[graph.getVexNum()];
        while (!stack.isEmpty()) {
            //出栈
            int j = (int) stack.pop();
            //构造拓扑逆序列
            T.push(j);
            //计数
            ++count;

            //删除顶点，以及出发弧
            ArcNode node = graph.getVexs()[j].firstArc;
            while (node != null) {
                //获取弧指向的顶点
                int k = node.adjVex;
                //入度减一，如果是入度为零，则压入栈中
                if (--indegrees[k] == 0) {
                    stack.push(k);
                }

                //构造事件最早开始时间
                if ((ee[j] + node.value) > ee[k]) {
                    ee[k] = ee[j] + node.value;
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


    /**
     * 关键路径
     *
     * @return
     */
    public boolean criticalPath(ALGraph graph) {

        //判断是否有环，是则终止算法
        if (!topologicalOrder(graph)) {
            return false;
        }
        //初始化事件最晚开始时间
        le = new int[graph.getVexNum()];
        for (int i = 0; i < graph.getVexNum(); i++) {
            le[i] = ee[graph.getVexNum() - 1];
        }
        //获取事件最晚开始时间
        while (!T.isEmpty()) {
            int j = (int) T.pop();
            for (ArcNode node = graph.getVexs()[j].firstArc; node != null; node = node.nextArc) {
                //该弧指向的顶点
                int k = node.adjVex;
                //弧上的权值
                int value = node.value;
                // le(i) = min{le(i)-len<vi,vj>}
                if ((le[k] - value) < le[j]) {
                    le[j] = le[k] - value;
                }
            }
        }

        //打印
        for (int j = 0; j < graph.getVexNum(); j++) {
            for (ArcNode node = graph.getVexs()[j].firstArc; node != null; node = node.nextArc) {
                //弧指向的顶点
                int k = node.adjVex;
                //该弧的权值
                int value = node.value;
                //活动的开始时间
                int ee = this.ee[j];
                //活动的结束时间
                int el = le[k] - value;
                //标识关键路径的顶点
                char tag = (ee == el ? '*' : ' ');
                System.out.println(graph.getVex(j) + " -> " + graph.getVex(k) + " " + value + " " + ee + " " + el + " " + tag);
            }
        }
        return true;
    }
}

