package code.code150.question105;

import common.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length);
    }

    /**
     * 前序遍历的第一个节点就是当前根节点R
     * 中序遍历，R的左侧为左子树，R右侧为右子树，R的前一个元素为左子树最后一个元素L
     * 前序遍历，L元素后面的为右子树节点
     *
     * @param preorder
     * @param ps
     * @param inorder
     * @param is
     * @param length
     * @return
     */
    private TreeNode buildTreeHelper(int[] preorder, int ps, int[] inorder, int is, int length) {
        TreeNode root = null;
        if (length != 0) {
            root = new TreeNode(preorder[ps]);
            //在中序数组中找根节点
            for (int i = length - 1; i >= 0; i--) {
                if (inorder[i + is] == preorder[ps]) {
                    root.left = buildTreeHelper(preorder, ps + 1, inorder, is, i);
                    root.right = buildTreeHelper(preorder, ps + i + 1, inorder, is + i + 1, length - i - 1);
                    break;
                }
            }
        }
        return root;
    }
}
