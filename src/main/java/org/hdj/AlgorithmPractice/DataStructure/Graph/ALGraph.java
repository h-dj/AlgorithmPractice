package org.hdj.AlgorithmPractice.DataStructure.Graph;

import java.util.Scanner;

/**
 * @Auther: h_dj
 * @Date: 2019/1/24 17:27
 * @Description: 邻接表
 */
public class ALGraph<T> implements IGraph<T> {
    //图的类型标识
    private GraphKind kind;
    //图当前顶点数和边数
    private int vexNum, arcNum;
    //顶点
    private VNode<T>[] vexs;

    public ALGraph() {
        this(null, 0, 0, null);
    }

    public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode<T>[] vexs) {
        this.kind = kind;
        this.vexNum = vexNum;
        this.arcNum = arcNum;
        this.vexs = vexs;
    }

    @Override
    public void createGraph() {
        Scanner in = new Scanner(System.in);
        System.out.println("输入图的类型");
        GraphKind kind = GraphKind.valueOf(in.next());
        switch (kind) {
            case DG:
                createDG();
                return;
            case DN:
                createDN();
                return;
            case UDG:
                createUDG();
                return;
            case UDN:
                createUDN();
                return;
        }
    }

    /**
     * 构造无向网
     */
    private void createUDN() {
        Scanner in = new Scanner(System.in);
        System.out.println("请分别输入图的顶点和边： \n");
        vexNum = in.nextInt();
        arcNum = in.nextInt();
        vexs = new VNode[vexNum];

        System.out.println("请输入图的各个顶点\n");
        //构造顶点向量
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = new VNode(in.next());
        }

        System.out.println("请输入各边的两个顶点及权值：\n");
        for (int i = 0; i < arcNum; i++) {
            int v = locateVex(in.next());
            int u = locateVex(in.next());
            int value = in.nextInt();
            addArc(v, u, value);
            addArc(u, v, value);
        }
    }

    /**
     * 构造无向图
     */
    private void createUDG() {
        Scanner in = new Scanner(System.in);
        System.out.println("请分别输入图的顶点和边： \n");
        vexNum = in.nextInt();
        arcNum = in.nextInt();
        vexs = new VNode[vexNum];

        System.out.println("请输入图的各个顶点\n");
        //构造顶点向量
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = new VNode(in.next());
        }

        System.out.println("请输入各边的两个顶点：\n");
        for (int i = 0; i < arcNum; i++) {
            int v = locateVex(in.next());
            int u = locateVex(in.next());
            addArc(v, u, -1);
            addArc(u, v, -1);
        }
    }

    /**
     * 构造有向网
     */
    private void createDN() {
        Scanner in = new Scanner(System.in);
        System.out.println("请分别输入图的顶点和边： \n");
        vexNum = in.nextInt();
        arcNum = in.nextInt();
        vexs = new VNode[vexNum];

        System.out.println("请输入图的各个顶点\n");
        //构造顶点向量
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = new VNode(in.next());
        }

        System.out.println("请输入各边的两个顶点及权值：\n");
        for (int i = 0; i < arcNum; i++) {
            int v = locateVex(in.next());
            int u = locateVex(in.next());
            int value = in.nextInt();
            addArc(v, u, value);
        }
    }

    /**
     * 添加弧
     *
     * @param v     顶点v位置
     * @param u     顶点u位置
     * @param value 权值
     */
    private void addArc(int v, int u, int value) {
        //创建边结点
        ArcNode node = new ArcNode(u, value);
        //采用链表的头插法
        node.nextArc = vexs[v].firstArc;
        vexs[v].firstArc = node;
    }

    /**
     * 构造有向图
     */
    private void createDG() {
        Scanner in = new Scanner(System.in);
        System.out.println("请分别输入图的顶点和边： \n");
        vexNum = in.nextInt();
        arcNum = in.nextInt();
        vexs = new VNode[vexNum];

        System.out.println("请输入图的各个顶点\n");
        //构造顶点向量
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = new VNode(in.next());
        }

        System.out.println("请输入各边的两个顶点：\n");
        for (int i = 0; i < arcNum; i++) {
            int v = locateVex(in.next());
            int u = locateVex(in.next());
            addArc(v, u, 0);
        }
    }

    @Override
    public int getVexNum() {
        return vexNum;
    }

    @Override
    public int getArcNum() {
        return arcNum;
    }

    /**
     * 返回顶点v的值
     *
     * @param vIndex 顶点位置
     * @return
     */
    @Override
    public T getVex(int vIndex) {
        //判断索引是否合法
        if (vIndex < 0 || vIndex >= vexNum)
            throw new RuntimeException("顶点不存在： vIndex:" + vIndex);
        return vexs[vIndex].data;
    }

    /**
     * 获取顶点的位置
     *
     * @param v
     * @return
     */
    @Override
    public int locateVex(Object v) {
        for (int i = 0; i < vexNum; i++) {
            if (vexs[i].data.equals(v)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回第一个邻接点
     */
    @Override
    public int firstAdjVex(int vIndex) {
        if (vIndex < 0 || vIndex >= vexNum)
            throw new RuntimeException("顶点不存在： vIndex:" + vIndex);

        //获取查询顶点
        VNode<T> node = vexs[vIndex];
        //获取第一条依附该顶点的弧的结点
        if (node.firstArc != null) {
            return node.firstArc.adjVex;
        }
        return -1;
    }

    /**
     * 获取顶点v相对顶点w的下一个邻接点
     * <p>
     * 时间 复杂度O(n)
     *
     * @param vIndex
     * @param wIndex
     * @return
     */
    @Override
    public int nextAdjVex(int vIndex, int wIndex) {
        if (vIndex < 0 || vIndex >= vexNum)
            throw new RuntimeException("顶点不存在： vIndex:" + vIndex);

        //获取查询顶点v
        VNode<T> v = vexs[vIndex];
        //获取顶点v的第一个边结点
        ArcNode wArc = v.firstArc;
        while (wArc != null) {
            //找出邻接顶点w
            if (wArc.adjVex == wIndex) {
                break;
            }
            wArc = wArc.nextArc;
        }
        //如果邻接顶点w不为空，并且邻接顶点w的下一个邻接点也不为空，则返回下一个邻接点的位置
        if (wArc != null && wArc.nextArc != null) {
            return wArc.nextArc.adjVex;
        }
        return -1;
    }

    public GraphKind getKind() {
        return kind;
    }

    public VNode<T>[] getVexs() {
        return vexs;
    }

}
