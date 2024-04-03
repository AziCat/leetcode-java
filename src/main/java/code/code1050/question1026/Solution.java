package code.code1050.question1026;

import common.TreeNode;

/**
 * @author yjh
 * @since 2023/4/19
 */
public class Solution {
    private int ans = 0;

    /**
     * 最大祖先差异
     * 树中的节点数在 2 到 5000 之间。
     * 0 <= Node.val <= 10^5
     *
     * @param root
     * @return int
     */
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        int[] temp = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        if (null != root) {
            int[] leftArr = dfs(root.left);
            int[] rightArr = dfs(root.right);
            int min = Math.min(root.val, Math.min(leftArr[0], rightArr[0]));
            int max = Math.max(root.val, Math.max(leftArr[1], rightArr[1]));
            ans = Math.max(ans, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
            temp[0] = Math.min(root.val, min);
            temp[1] = Math.max(root.val, max);
        }
        return temp;
    }
}
