package code.code150.question101;

import common.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        } else {
            if (right != null) {
                if (isSymmetric(left.left,right.right)) {
                    if (left.val == right.val) {
                        return isSymmetric(left.right,right.left);
                    }
                }
            }
        }
        return false;
    }
}
