package code.code150.question106;

import common.TreeNode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 */
public class Solution {
    /**
     * 参考上一题Question105的解法，后序遍历的根节点在最后一个
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, postorder, 0, postorder.length);
    }

    private TreeNode helper(int[] inorder, int is, int[] postorder, int ps, int length) {
        TreeNode root = null;
        if (length != 0) {
            root = new TreeNode(postorder[ps + length - 1]);
            for (int i = length - 1; i >= 0; i--) {
                if (inorder[is + i] == postorder[ps + length - 1]) {
                    root.left = helper(inorder, is, postorder, ps, i);
                    root.right = helper(inorder, is + i + 1, postorder, ps + i, length - i - 1);
                }
            }
        }
        return root;
    }
}
