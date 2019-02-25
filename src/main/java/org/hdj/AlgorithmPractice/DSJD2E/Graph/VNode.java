package org.hdj.AlgorithmPractice.DSJD2E.Graph;

/**
 * @Auther: h_dj
 * @Date: 2019/1/24 16:46
 * @Description: 邻接表顶点结点类
 */
public class VNode<T> {
    //顶点数据
    public T data;
    //指向第一条依附该顶点的弧
    public ArcNode firstArc;

    public VNode() {
        this(null, null);
    }

    public VNode(T data) {
        this(data, null);
    }

    public VNode(T data, ArcNode firstArc) {
        this.data = data;
        this.firstArc = firstArc;
    }
}
