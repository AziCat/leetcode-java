package code.code300.question257;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/18
 */
public class Solution {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        buildPath(root, "", ans);
        return ans;
    }

    private void buildPath(TreeNode root, String s, List<String> ans) {
        if (null != root) {
            s += String.valueOf(root.val);
            if (null == root.left && null == root.right) {
                ans.add(s);
            } else {
                s += "->";
                buildPath(root.left, s, ans);
                buildPath(root.right, s, ans);
            }
        }
    }
}
