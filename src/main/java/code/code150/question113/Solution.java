package code.code150.question113;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

链接：https://leetcode-cn.com/problems/path-sum-ii
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, sum, ans, temp);
        return ans;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> temp) {
        if (null != root) {
            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    temp.add(root.val);
                    ans.add(new ArrayList<>(temp));
                    temp.remove(temp.size() - 1);
                }
            }else {
                temp.add(root.val);
                helper(root.left,sum-root.val,ans,temp);
                helper(root.right,sum-root.val,ans,temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

