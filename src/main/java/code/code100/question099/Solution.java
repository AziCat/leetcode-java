package code.code100.question099;

import common.TreeNode;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 */
public class Solution {
    private TreeNode first;
    private TreeNode second;
    private TreeNode pre;

    public void recoverTree(TreeNode root) {
        //中序遍历，正常搜索二叉树中序遍历值是会递增的
        inOrderTraverse(root);
        //交换节点
        swap(first, second);
    }

    private void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            if (pre!=null && root.val < pre.val) {
                //如果发生值下降，记录下降节点，pre是第一个下降节点的根节点
                if (first == null) {
                    first = pre;
                    second = root;
                } else {
                    //第二次下降
                    second = root;
                }
            }
            pre = root;
            inOrderTraverse(root.right);
        }
    }
}
