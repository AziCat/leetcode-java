package code.code450.question404;

import common.TreeNode;

/**
 * @author yan
 * @version 1.0
 * @date 2020/8/24
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (null == root) {
            return 0;
        }
        if (isLeft && root.left == null && root.right == null) {
            return root.val;
        } else {
            return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
        }
    }
}
