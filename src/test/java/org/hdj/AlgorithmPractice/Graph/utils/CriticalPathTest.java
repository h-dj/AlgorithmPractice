package org.hdj.AlgorithmPractice.Graph.utils;

import org.hdj.AlgorithmPractice.Graph.ALGraph;
import org.hdj.AlgorithmPractice.Graph.ArcNode;
import org.hdj.AlgorithmPractice.Graph.GraphKind;
import org.hdj.AlgorithmPractice.Graph.VNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: h_dj
 * @Date: 2019/2/7 22:07
 * @Description:
 */
public class CriticalPathTest {

    private ALGraph graph;
    private CriticalPath criticalPath;

    @Before
    public void init() {
        ArcNode v12 = new ArcNode(1, 6);
        ArcNode v13 = new ArcNode(2, 4, v12);
        ArcNode v14 = new ArcNode(3, 5, v13);
        VNode v1 = new VNode("v1", v14);


        ArcNode v25 = new ArcNode(4, 1);
        VNode v2 = new VNode("v2", v25);


        ArcNode v35 = new ArcNode(4, 1);
        VNode v3 = new VNode("v3", v35);

        ArcNode v46 = new ArcNode(5, 2);
        VNode v4 = new VNode("v4", v46);


        ArcNode v57 = new ArcNode(6, 9);
        ArcNode v58 = new ArcNode(7, 7, v57);
        VNode v5 = new VNode("v5", v58);


        ArcNode v68 = new ArcNode(7, 4);
        VNode v6 = new VNode("v6", v68);

        ArcNode v79 = new ArcNode(8, 2);
        VNode v7 = new VNode("v7", v79);

        ArcNode v89 = new ArcNode(8, 4);
        VNode v8 = new VNode("v8", v89);

        VNode v9 = new VNode("v9");


        VNode[] vexs = {v1, v2, v3, v4, v5, v6, v7, v8, v9};
        graph = new ALGraph(GraphKind.DG, 9, 11, vexs);
        criticalPath = new CriticalPath();
    }

    @Test
    public void criticalPath() throws Exception {
        criticalPath.criticalPath(graph);
    }

}