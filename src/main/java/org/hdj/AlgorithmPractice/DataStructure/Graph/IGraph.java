package org.hdj.AlgorithmPractice.DataStructure.Graph;

/**
 * 图的抽象数据类型接口
 */
public interface IGraph<T> {
    /**
     * 创建一个图
     */
    void createGraph();

    /**
     * 获取顶点数
     *
     * @return
     */
    int getVexNum();

    /**
     * 获取图的边数
     *
     * @return
     */
    int getArcNum();

    /**
     * 获取指定顶点
     *
     * @param vIndex 顶点位置
     * @return
     */
    T getVex(int vIndex);

    /**
     * 通过顶点的值，获取顶点的位置
     *
     * @param v
     * @return
     */
    int locateVex(Object v);

    /**
     * 返回顶点v的 邻接点， 没有返回-1
     *
     * @param vIndex
     * @return
     */
    int firstAdjVex(int vIndex);

    /**
     * 返回顶点v 相对顶点w的下一个邻接点，若顶点w是顶点v的最后一个邻接点，则返回-1，其中0<= v, w<=vexNum
     *
     * @param vIndex
     * @param wIndex
     * @return
     */
    int nextAdjVex(int vIndex, int wIndex);
}
