package code.code100.question100;

import common.TreeNode;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        } else{
            return q != null && isSameTree(p.left, q.left) && p.val == q.val && isSameTree(p.right, q.right);
        }
    }
}
