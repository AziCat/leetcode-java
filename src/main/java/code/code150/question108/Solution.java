package code.code150.question108;

import common.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Solution {
    /**
     * 二分找中位点，然后递归中位点两边的数组
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        //int mid = s + (e - s) / 2;
        int mid = (s + e) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, s, mid - 1);
        root.right = helper(nums, mid + 1, e);
        return root;
    }
}
