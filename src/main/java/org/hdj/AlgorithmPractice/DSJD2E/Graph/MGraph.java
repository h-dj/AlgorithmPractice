package org.hdj.AlgorithmPractice.DSJD2E.Graph;

import java.util.Scanner;

/**
 * @Auther: h_dj
 * @Date: 2019/1/24 15:55
 * @Description: 邻接矩阵
 * <p>
 * 查找图的度：时间复杂度O(n)
 * 查找图的边：时间复杂度O(n^2)
 * 邻接矩阵(不管顶点之间是否有边)空间复杂度：O(n^2)
 */
public class MGraph<T> implements IGraph<T> {
    public final static int INFINITY = Integer.MAX_VALUE;
    //图的类型
    private GraphKind kind;
    //顶点数和边数
    private int vexNum, arcNum;
    //顶点
    private Object[] vexs;
    //邻接矩阵
    private int[][] arcs;


    public MGraph() {
        this(null, 0, 0, null, null);
    }

    public MGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs, int[][] arcs) {
        this.kind = kind;
        this.vexNum = vexNum;
        this.arcNum = arcNum;
        this.vexs = vexs;
        this.arcs = arcs;
    }

    /**
     * 创建图
     */
    @Override
    public void createGraph() {

    }

    /**
     * 创建无向图(对称矩阵)
     */
    private void createUDN() {
        Scanner in = new Scanner(System.in);
        System.out.println("请分别输入图的顶点和边： \n");
        vexNum = in.nextInt();
        arcNum = in.nextInt();
        vexs = new Object[vexNum];
        arcs = new int[vexNum][vexNum];
        System.out.println("请输入图的各个顶点\n");

        //构造顶点向量
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = in.next();
        }

        //初始化邻接矩阵
        for (int i = 0; i < vexNum; i++) {
            for (int j = 0; j < vexNum; j++) {
                arcs[i][j] = INFINITY;
            }
        }

        System.out.println("请输入各边的两个顶点及权值：\n");
        for (int i = 0; i < arcNum; i++) {
            int v = locateVex(in.next());
            int u = locateVex(in.next());
            arcs[v][u] = arcs[u][v] = in.nextInt();
        }
    }

    /**
     * 有向网
     * <p>
     * 构造n个顶点和e条边的图
     * 时间复杂度： O(n^2+en)
     */
    private void createDN() {
        Scanner in = new Scanner(System.in);
        System.out.println("请分别输入图的顶点和边： \n");
        vexNum = in.nextInt();
        arcNum = in.nextInt();
        vexs = new Object[vexNum];
        arcs = new int[vexNum][vexNum];
        System.out.println("请输入图的各个顶点\n");
        //构造顶点向量
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = in.next();
        }

        //初始化邻接矩阵
        for (int i = 0; i < vexNum; i++) {
            for (int j = 0; j < vexNum; j++) {
                arcs[i][j] = INFINITY;
            }
        }

        System.out.println("请输入各边的两个顶点及权值：\n");
        for (int i = 0; i < arcNum; i++) {
            int v = locateVex(in.next());
            int u = locateVex(in.next());
            arcs[v][u] = in.nextInt();
        }
    }

    /**
     * 获取图顶点数
     *
     * @return
     */
    @Override
    public int getVexNum() {
        return vexNum;
    }

    /**
     * 获取图边数
     *
     * @return
     */
    @Override
    public int getArcNum() {
        return arcNum;
    }

    /**
     * 获取顶点值
     *
     * @param vIndex 顶点位置
     * @return
     */
    @Override
    public T getVex(int vIndex) {
        return (T) vexs[vIndex];
    }

    /**
     * 获取顶点位置
     * <p>
     * 时间复杂度O(n)
     *
     * @param v
     * @return
     */
    @Override
    public int locateVex(Object v) {
        for (int i = 0; i < vexNum; i++) {
            if (vexs[i].equals(v)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取顶点v的第一个邻接点的位置
     *
     * @param vIndex
     * @return
     */
    @Override
    public int firstAdjVex(int vIndex) {
        //判断顶点索引是否合法
        if (vIndex < 0 || vIndex >= vexNum) throw new RuntimeException("顶点不存在 index : " + vIndex);

        for (int i = 0; i < vexNum; i++) {
            //如果邻接矩阵中，顶点所在行，有顶点的权值不为零并且小于初始化值INFINITY，则该顶点为查找的一个邻接点
            if (arcs[vIndex][i] != 0 && arcs[vIndex][i] < INFINITY) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取顶点v相对w的下一个邻接点
     *
     * @param vIndex
     * @param wIndex
     * @return
     */
    @Override
    public int nextAdjVex(int vIndex, int wIndex) {
        //判断顶点索引是否合法
        if (vIndex < 0 && vIndex >= vexNum) throw new RuntimeException("顶点不存在 index : " + vIndex);

        //从相对顶点w的下一位置开始找
        for (int i = wIndex + 1; i < vexNum; i++) {
            //如果邻接矩阵中，顶点所在行，有顶点的权值不为零并且小于初始化值INFINITY，则该顶点为查找的一个邻接点
            if (arcs[vIndex][i] != 0 && arcs[vIndex][i] < INFINITY) {
                return i;
            }
        }
        return -1;
    }

    public GraphKind getKind() {
        return kind;
    }

    public Object[] getVexs() {
        return vexs;
    }

    public int[][] getArcs() {
        return arcs;
    }
}
