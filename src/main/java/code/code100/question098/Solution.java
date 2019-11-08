package code.code100.question098;

import common.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 */
public class Solution {
    private long min = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (min < root.val) {
                min = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
