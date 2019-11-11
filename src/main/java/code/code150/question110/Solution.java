package code.code150.question110;

import common.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (isBalanced(root.left)) {
                int left = root.left == null ? 0 : root.left.val;
                if (isBalanced(root.right)) {
                    int right = root.right == null ? 0 : root.right.val;
                    root.val = Math.max(left, right) + 1;
                    return Math.abs(left - right) < 2;
                }
            }
        }
        return false;
    }


}
