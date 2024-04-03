package code.code1400.question1379;

import common.TreeNode;

/**
 * 找出克隆二叉树中的相同节点
 *
 * @author yjh
 * @since 2024/4/3
 */
public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (null != original) {
            if (original.val == target.val) {
                return cloned;
            }
            TreeNode result = getTargetCopy(original.left, cloned.left, target);
            return null == result ? getTargetCopy(original.right, cloned.right, target) : result;
        }
        return null;
    }
}
