package code.code150.question111;

import common.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            if (root.left == null && root.right != null) {
                return minDepth(root.right) + 1;
            } else if (root.left != null && root.right == null) {
                return minDepth(root.left) + 1;
            }else {
                return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
            }
        }
    }
}
