package org.hdj.AlgorithmPractice.practice;

import java.util.*;

/**
 * @Description: 
 * <pre>
 *     牛客网 https://www.nowcoder.com/practice/f31fc6d3caf24e7f8b4deb5cd9b5fa97
 *     描述
给定一棵二叉树，已知其中的节点没有重复值，请判断该二叉树是否为搜索二叉树和完全二叉树。
输出描述：分别输出是否为搜索二叉树、完全二叉树。


数据范围：二叉树节点数满足 0 \le n \le 5000000≤n≤500000 ，二叉树上的值满足 0 \le val \le 1000000≤val≤100000
要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)

注意：空子树我们认为同时符合搜索二叉树和完全二叉树。
示例1
输入：
{2,1,3}
复制
返回值：
[true,true]
复制
示例2
输入：
{1,#,2}
复制
返回值：
[true,false]
复制
说明：
由于节点的右儿子大于根节点，无左子树，所以是搜索二叉树但不是完全二叉树     
示例3
输入：
{}
复制
返回值：
[true,true]
 *     
 *     
 * </pre>
 * @Author huangjiajian
 * @Date 2022/3/19 下午10:06
 */
public class TreeJudge {
    /**
     *
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt (TreeNode root) {
        if (root == null) {
            return new boolean[] {true, true};
        }
        boolean isBinaryTree = true, isCompleteTree = true,flag = false;
        // write code here
        LinkedList<TreeNode> list = new LinkedList();
        list.offer(root);
        //层次遍历
        while (!list.isEmpty()) {

            TreeNode pop = list.poll();
            //判断是否是完全二叉树
            if(flag  && !(pop.left==null && pop.right==null) ||  (pop.left==null && pop.right!=null)){
                isCompleteTree = false;
                break;
            }
            if (pop.left != null) {
                list.offer(pop.left);
            }
            if (pop.right != null) {
                list.offer(pop.right);
            }
            if(pop.left==null || pop.right==null){
                flag = true;
            }
        }

        //中序遍历 (左中右)
        List<Integer> sort = new ArrayList<>();
        list.clear();
        list.push(root);
        while (!list.isEmpty()) {
            //把左节点入栈
            while (list.peek() != null) {
                list.push(list.peek().left);
            }
            //弹出空节点
            list.pop();
            if (!list.isEmpty()) {
                TreeNode pop = list.pop();
                sort.add(pop.val);
                list.push(pop.right);
            }
        }

        for (int i = 0; i < sort.size() - 1; i++) {
            if (sort.get(i) > sort.get(i + 1)) {
                isBinaryTree = false;
                break;
            }
        }
        return new boolean[] {isBinaryTree, isCompleteTree};
    }
}


 class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
 }
