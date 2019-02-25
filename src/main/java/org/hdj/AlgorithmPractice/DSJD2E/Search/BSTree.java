package org.hdj.AlgorithmPractice.DSJD2E.Search;

import org.hdj.AlgorithmPractice.DSJD2E.Tree.LinkTree.BiTreeNode;

/**
 * @Auther: h_dj
 * @Date: 2019/2/19 15:22
 * @Description: 二叉排序查找
 */
public class BSTree {


    public BiTreeNode root;

    public BSTree() {
        root = null;
    }

    public void inOrderTraverse(BiTreeNode treeNode) {
        if (treeNode == null) return;

        //遍历左子树
        inOrderTraverse(treeNode.LChild);

        //结点数据
        System.out.print(treeNode.data.toString() +" ");

        //遍历右子树
        inOrderTraverse(treeNode.RChild);
    }

    public Object searchBST(Integer key) {
        if (key == null) {
            return null;
        }

        return searchBST(root, key);
    }

    /**
     * 二叉排序树查找
     *
     * @param root 根结点
     * @param key  搜索关键字
     * @return
     */
    public Object searchBST(BiTreeNode<Integer> root, int key) {
        if (root != null) {
            //如果找到，则返回值
            if (root.data == key) {
                return root.data;
            }
            //如果查找值比根结点关键字值小，则继续搜索左子树
            if (root.data > key) {
                return searchBST(root.LChild, key);
            } else {
                //否则，则搜索右子树
                return searchBST(root.RChild, key);
            }
        }
        return null;
    }


    public boolean insertBST(Integer value) {
        if (value == null) {
            return false;
        }
        //如果根结点为空，则插入二叉排序树，作为根结点
        if (root == null) {
            root = new BiTreeNode(value);
            return true;
        }
        //否则，插入对应位置
        return insertBST(root, value);

    }

    /**
     * 二叉排序树插入
     *
     * @return
     */
    public boolean insertBST(BiTreeNode<Integer> p, int value) {

        //如果插入的值，在二叉排序树中已存在，则不再插入该值
        if (p.data == value) {
            return false;
        }

        //如果待插入元素值小于当前结点值，则插入到左子树中
        if (p.data > value) {
            //先判断左子树是否为空
            //为空，则直接作为当前结点的左孩子
            if (p.LChild == null) {
                p.LChild = new BiTreeNode(value);
                return true;
            } else {
                //否则，插入到当前结点的左子树
                return insertBST(p.LChild, value);
            }
        } else {
            //判断右子树是否为空
            //为空，则直接作为当前结点的右孩子
            if (p.RChild == null) {
                p.RChild = new BiTreeNode(value);
                return true;
            } else {
                //否则，插入到当前结点的右子树
                return insertBST(p.RChild, value);
            }
        }
    }


    public Object removeBST(Integer key) {
        if (root == null || key == null) {
            return null;
        }
        return removeBST(root, key, null);
    }

    /**
     * 删除
     *
     * @param p
     * @param key
     * @param parent
     * @return
     */
    public Object removeBST(BiTreeNode<Integer> p, int key, BiTreeNode<Integer> parent) {
        if (p == null) {
            return null;
        }

        //如果搜索关键字小于当前结点值，
        if (p.data > key) {
            // 则在该结点的左子树搜索
            return removeBST(p.LChild, key, p);
        } else if (p.data < key) {
            //否则，在该结点的右子树搜索
            return removeBST(p.RChild, key, p);
        } else if (p.LChild != null && p.RChild != null) {
            //如果搜索值相等，并且左右子树都存在
            //寻找右子树中的最左孩子
            BiTreeNode<Integer> innext = p.RChild;
            while (innext.LChild != null) {
                innext = innext.LChild;
            }
            // 用右子树中最左的孩子，替换删除的结点
            p.data = innext.data;
            //删除找到的最左孩子结点
            return removeBST(p.RChild, p.data, p);
        } else {
            //相等，且只有左结点或右结点的情况
            //删除根结点
            if (parent == null) {
                if (p.LChild != null) {
                    root = p.LChild;
                } else {
                    root = p.RChild;
                }
                return p.data;
            }
            //如果p 是 parent 的左孩子
            if (p == parent.LChild) {
                //删除的p结点，左孩子不为空，则以左孩子替换p
                if (p.LChild != null) {
                    parent.LChild = p.LChild;
                } else {
                    //否则以右孩子替换
                    parent.RChild = p.RChild;
                }
            } else if (p.LChild != null) {
                //如果p是parent的右孩子，并且左孩子不为空，
                //则以p的左孩子替换 p 作为parent结点的右孩子
                parent.RChild = p.LChild;
            } else {
                //否则，以p的右孩子替换 p 作为parent结点的右孩子
                parent.RChild = p.RChild;
            }
            return p.data;
        }
    }
}
