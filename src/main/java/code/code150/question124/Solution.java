package code.code150.question124;

import common.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private void helper(TreeNode root) {
        if (null != root) {
            helper(root.left);
            helper(root.right);
            if (root.left == null && root.right == null) {
                max = Math.max(max, root.val);
            } else {
                int rootVal = root.val;
                int leftTemp = root.val, rightTemp = root.val;

                if (root.left != null && root.left.val > 0) {
                    rootVal += root.left.val;
                    leftTemp = root.val + root.left.val;
                }
                if (root.right != null && root.right.val > 0) {
                    rootVal += root.right.val;
                    rightTemp = root.val + root.right.val;
                }
                root.val = Math.max(leftTemp, rightTemp);
                max = Math.max(max, rootVal);
            }
        }
    }
}
