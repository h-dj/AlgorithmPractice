package org.hdj.AlgorithmPractice.DSJD2E.Sort;

/**
 * @Auther: h_dj
 * @Date: 2019/2/13 17:26
 * @Description: 树形排序
 * <p>
 * 满二叉树的性质
 * <p>
 * 对于具有n个结点的完全二叉树，若从根结点开始自上而下，从左到右开始编号，对于任意编号i（0<=i<n）的结点有：
 * 若i=0,则结点为根结点，没有双亲，若i>0,则它的双亲结点编号为 (i-1)/2
 * 若2i+1 >=n ,则编号i结点无左孩子，否则编号2i+1的结点就是它的左孩子
 * 若2i+2 >=n ,则编号i结点无右孩子，否则编号2i+2的结点就是它的右孩子
 * <p>
 * 空间复杂度：
 * 时间复杂度
 */
public class TreeSelectionSort {

    enum ActiveFlag {
        ACTIVE,//参选
        UNACTIVE;//不参选
    }

    /**
     * 胜者树节点
     */
    class TreeNode {
        //数据
        public int data;
        //该节点的索引
        public int index;
        //标识
        public ActiveFlag active;
    }


    public void treeSelectionSort(int[] elements) {
        //胜者树结点数组
        TreeNode[] tree;
        // 叶子节点数
        int leafSize = 1;

        //得到胜者树的叶子结点数， 该结点数必须为2的幂，才能构造成满二叉树
        while (leafSize < elements.length) {
            leafSize = leafSize * 2;
        }


        //胜者树的所有结点数
        //二叉树的第i层结点数最多： 2^i
        //二叉树的所有结点数最多： 2^k-1 = 2*2^i-1 (k为深度)
        int treeSize = 2 * leafSize - 1;

        // 叶子结点数存放的起始位置
        int loadIndex = leafSize - 1;
        //创建胜者树数组
        tree = new TreeNode[treeSize];
        // 待排序序列下标
        int j = 0;
        //把待排序结点复制到胜者树的叶子结点中
        for (int i = loadIndex; i < treeSize; i++) {
            tree[i] = new TreeNode();
            tree[i].index = i;

            if (j < elements.length) {
                tree[i].active = ActiveFlag.ACTIVE;
                tree[i].data = elements[j++];
            } else {
                tree[i].active = ActiveFlag.UNACTIVE;
            }
        }

        //先进行一次比较查找关键字值最小的结点
        int i = loadIndex;
        while (i > 0) {
            j = i;
            //处理各对比赛对手
            while (j < 2 * i) {
                //完全二叉树的性质：
                //若i=0,则结点为根结点，没有双亲，若i>0,则它的双亲结点编号为 (i-1)/2
                if (tree[j + 1].active == ActiveFlag.UNACTIVE || (tree[j].data <= tree[j + 1].data)) {
                    //左孩子胜者，晋级（成为父节点）
                    tree[(j - 1) / 2] = tree[j];
                } else {
                    //右孩子胜者，晋级（成为父节点）
                    tree[(j - 1) / 2] = tree[j + 1];
                }
                //下一对比赛选手
                j += 2;
            }
            i = (i - 1) / 2;
        }

        //继续找出剩余最小
        for (i = 0; i < elements.length - 1; i++) {
            //将胜者树的根(最小者)存入数组
            elements[i] = tree[0].data;
            //该结点选手落选，不再比赛
            tree[tree[0].index].active = ActiveFlag.UNACTIVE;
            //调整胜者树，再次两两比赛，筛选出最小值
            updateTree(tree, tree[0].index);
        }
        elements[elements.length - 1] = tree[0].data;
    }


    private void updateTree(TreeNode[] tree, int index) {
        // 比赛对手的索引
        int j;

        if (index % 2 == 0) {
            //index 为偶数，对手为左结点
            tree[(index - 1) / 2] = tree[index - 1];
        } else {
            //index 为奇数，对手为右结点
            tree[(index - 1) / 2] = tree[index + 1];
        }
        //最小记录输出，其对手上升到父结点
        index = (index - 1) / 2;
        while (index > 0) {
            if (index % 2 == 0) {
                //index 为偶数，对手为左结点
                j = index - 1;
            } else {
                //index 为奇数，对手为右结点
                j = index + 1;
            }

            //比赛对手中有一个为空
            if (tree[index].active == ActiveFlag.UNACTIVE || tree[j].active == ActiveFlag.UNACTIVE) {
                if (tree[index].active == ActiveFlag.ACTIVE) {
                    //i晋级，
                    tree[(index - 1) / 2] = tree[index];
                } else {
                    //落选
                    tree[(index - 1) / 2] = tree[j];
                }
            } else {
                if (tree[index].data <= tree[j].data) {
                    tree[(index - 1) / 2] = tree[index];
                } else {
                    tree[(index - 1) / 2] = tree[j];
                }
            }
            index = (index - 1) / 2;
        }
    }


}
