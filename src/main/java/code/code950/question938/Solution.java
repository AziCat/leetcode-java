package code.code950.question938;

import common.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * @author yjh
 * @since 2021.04.27
 */
public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (null != root) {
            if (root.val >= low && root.val <= high) {
                return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
            } else if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            } else {
                return rangeSumBST(root.right, low, high);
            }
        }
        return 0;
    }
}
