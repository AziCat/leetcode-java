package code.code150.question107;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            helper(root, ans, 0);
        }
        return ans;
    }

    private void helper(TreeNode root, List<List<Integer>> ans, int level) {
        if (ans.size() == level) {
            ans.add(0, new ArrayList<>());
        }
        if (root != null) {
            ans.get(ans.size() - level - 1).add(root.val);
            if (root.left != null) {
                helper(root.left, ans, level + 1);
            }
            if (root.right != null) {
                helper(root.right, ans, level + 1);
            }
        }
    }
}
