package code.code600.question572;

import common.TreeNode;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/5/7
 */
public class Solution {
    /**
     * 如果t是s的子树有以下3种情况
     * s=t
     * s某个左子树=t
     * s某个右子树=t
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean check = isSameTree(s, t);
        if (!check && null != s) {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return check;
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }
}
