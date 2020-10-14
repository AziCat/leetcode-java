package code.code550.question530;

import common.TreeNode;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * @author yan
 * @version 1.0
 * @date 2020/10/12
 */
public class Solution {
    private int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return ans;
    }

    /**
     * int[0]为root最小值 int[1]为root最大值
     *
     * @param root
     * @return
     */
    private int[] helper(TreeNode root) {
        int[] rootValue = new int[]{root.val, root.val};
        if (null != root.left) {
            int[] leftValue = helper(root.left);
            ans = Math.min(ans, Math.abs(leftValue[1] - root.val));
            rootValue[0] = leftValue[0];
        }
        if (null != root.right) {
            int[] rightValue = helper(root.right);
            ans = Math.min(ans, Math.abs(rightValue[0] - root.val));
            rootValue[1] = rightValue[1];
        }
        return rootValue;
    }
}
