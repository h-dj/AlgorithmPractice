package org.hdj.AlgorithmPractice.DataStructure.Sort;

/**
 * @Auther: h_dj
 * @Date: 2019/2/14 17:17
 * @Description: 堆排序
 */
public class HeadSort {

    /**
     * 筛选法调整堆
     * <p>
     * 以low为根结点的子树调整为小顶堆
     */
    public static void sift(int low, int hight, int[] elements) {
        //定义根结点的索引
        int i = low;
        int j = 2 * i + 1;
        //暂时值
        int temp = elements[i];
        //
        while (j < hight) {

            //比较左右子孩子的大小，找出最小的结点
            if (j < hight - 1 && elements[j] > elements[j + 1]) {
                j++;
            }
            //父结点与最小子结点比较，如果父结点大于子节点，则交换位置
            if (temp > elements[j]) {
                elements[i] = elements[j];
                //以j为父结点的子树，再次调整堆
                //对于具有n个结点的完全二叉树
//                1. 若i=0,则结点为根结点，没有双亲，若i>0,则它的双亲结点编号为 (i-1)/2
//                2. 若2i+1 >=n ,则编号i结点无左孩子，否则编号2i+1的结点就是它的左孩子
//                3. 若2i+2 >=n ,则编号i结点无右孩子，否则编号2i+2的结点就是它的右孩子
                i = j;
                j = 2 * i + 1;
            } else {
                //退出循环
                j = hight + 1;
            }
        }
        elements[i] = temp;
    }

    /**
     * 堆排序
     *
     * @param elements
     */
    public static void headSort(int[] elements) {
        //创建堆
        int len = elements.length;
        //2. 以下标(n/2-1) 作为开始调整子树的根结点，进行筛选法调整堆
        //步骤3，4
        for (int i = (len / 2 - 1); i >= 0; i--) {
            sift(i, len, elements);
        }

        //步骤：5. 6
        for (int i = len - 1; i > 0; i--) {
            //将根结点与二叉树最后一个结点交换
            int temp = elements[0];
            elements[0] = elements[i];
            elements[i] = temp;
            //使用筛选法调整堆法，调整为大顶堆
            sift(0, i, elements);
        }
    }

    /**
     * 打印堆
     * @param elements
     */
    public static void print(int[] elements){
        for (int i = 0; i < elements.length;) {

        }
    }
}
