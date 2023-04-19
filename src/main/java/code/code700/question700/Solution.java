package code.code700.question700;

import common.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * @author yjh
 * @since 2021/11/26
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root || root.val == val) {
            return root;
        }
        return val > root.val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
