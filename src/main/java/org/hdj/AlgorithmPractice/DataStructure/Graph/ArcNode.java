package org.hdj.AlgorithmPractice.DataStructure.Graph;

/**
 * @Auther: h_dj
 * @Date: 2019/1/24 16:47
 * @Description: 邻接表边结点类
 */
public class ArcNode {
    //该弧指向的顶点位置
    public int adjVex;
    //边（弧）的权值4
    public int value;
    //指向下一条弧
    public ArcNode nextArc;


    public ArcNode() {
        this(-1, 0, null);
    }

    public ArcNode(int adjVex, int value) {
        this(adjVex, value, null);
    }

    public ArcNode(int adjVex, int value, ArcNode nextArc) {
        this.adjVex = adjVex;
        this.value = value;
        this.nextArc = nextArc;
    }
}
