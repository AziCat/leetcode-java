package code.code150.question102;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (null != root) {
            queue.addLast(root);
        }
        buildAns(ans, queue);
        return ans;
    }

    private void buildAns(List<List<Integer>> ans, LinkedList<TreeNode> queue) {
        int size = queue.size();
        if (size != 0) {
            int i = 0;
            List<Integer> subList = new ArrayList<>();
            while (i < size) {
                TreeNode node = queue.pollFirst();
                subList.add(node.val);
                if (null != node.left) {
                    queue.addLast(node.left);
                }
                if (null != node.right) {
                    queue.addLast(node.right);
                }
                i++;
            }
            ans.add(subList);
            buildAns(ans,queue);
        }
    }
}
