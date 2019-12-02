package code.code150.question145;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/2
 */
public class Solution {
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (null != root) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            ans.add(root.val);
        }
        return ans;
    }
}
