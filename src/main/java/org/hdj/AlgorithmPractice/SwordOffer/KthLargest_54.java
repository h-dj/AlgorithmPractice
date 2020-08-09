package org.hdj.AlgorithmPractice.SwordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/8/9 下午4:28
 * @description: <pre>
 *     给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * </pre>
 */
public class KthLargest_54 {

    /**
     * 考察中序遍历(二叉搜索树, 的特性是左节点比父节点小，右节点比父节点大，当使用中序遍历时，可以获取有小到大排序的节点)
     * <p>
     * 这里是中序遍历的顺序
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            //到达最左节点
            while (stack.peek() != null) {
                stack.push(stack.peek().left);
            }
            //弹出空结点
            stack.pop();
            if (!stack.isEmpty()) {
                //弹出节点
                node = stack.pop();
                queue.offerLast(node.val);
                if (queue.size() > k) {
                    queue.removeFirst();
                }
                //把该结点的右子结点入栈
                stack.push(node.right);
            }
        }
        return queue.removeFirst();
    }


    /**
     * 中序遍历的倒序
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthLargest2(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            //到达最右节点
            while (stack.peek() != null) {
                stack.push(stack.peek().right);
            }
            //弹出空结点
            stack.pop();
            if (!stack.isEmpty()) {
                //弹出节点
                node = stack.pop();
                if ((--k) == 0) {
                    return node.val;
                }
                //把该结点的左子结点入栈
                stack.push(node.left);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Utils.genTree("3124", "1234", 0, 0, 4);
        Utils.display(treeNode);
        int i = kthLargest(treeNode, 1);
        System.out.println(i);
        i = kthLargest2(treeNode, 1);
        System.out.println(i);
    }
}
