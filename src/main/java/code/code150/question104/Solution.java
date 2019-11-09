package code.code150.question104;

import common.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 */
public class Solution {
    private int max = 0;

    public int maxDepth(TreeNode root) {
        maxDepth(root, 1);
        return max;
    }

    private void maxDepth(TreeNode root, int deepLevel) {
        if (root != null) {
            max = Math.max(max, deepLevel);
            if (null != root.left) {
                maxDepth(root.left, deepLevel + 1);
            }
            if (null != root.right) {
                maxDepth(root.right, deepLevel + 1);
            }
        }
    }
}
