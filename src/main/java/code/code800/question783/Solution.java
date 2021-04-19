package code.code800.question783;

import common.TreeNode;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * @author yjh
 * @version 1.0
 * @since 2021/4/13 16:50
 */
public class Solution {
    private TreeNode pre = null;   //pre记录前一节点
    private int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            res = Math.min(root.val - pre.val, res);   //记录最小
        }
        pre = root;
        dfs(root.right);
    }

}
