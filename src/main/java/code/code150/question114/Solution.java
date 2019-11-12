package code.code150.question114;

import common.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
public class Solution {


    public void flatten(TreeNode root) {
        if (null != root) {
            helper(root);
        }

    }

    /**
     * 左子树展开，返回最后一个节点leftEnd
     * 右子树展开，返回最后一个节点rightEnd
     * leftEnd连接root.right，root.right = root.left，置空root.left，返回rightEnd
     *
     * @param root
     */
    private TreeNode helper(TreeNode root) {
        if (null != root) {
            TreeNode leftEnd = helper(root.left);
            TreeNode rightEnd = helper(root.right);
            if (leftEnd == null && rightEnd == null) {
                return root;
            }
            if (leftEnd != null) {
                leftEnd.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            return rightEnd == null ? leftEnd : rightEnd;
        }
        return null;
    }

}
