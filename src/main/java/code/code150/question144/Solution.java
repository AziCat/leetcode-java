package code.code150.question144;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/2
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (null != root) {
            preorderTraversal(root, ans);
        }
        return ans;
    }

    private void preorderTraversal(TreeNode root, List<Integer> ans) {
        ans.add(root.val);
        if (null != root.left) {
            preorderTraversal(root.left, ans);
        }
        if (null != root.right) {
            preorderTraversal(root.right, ans);
        }
    }
}
