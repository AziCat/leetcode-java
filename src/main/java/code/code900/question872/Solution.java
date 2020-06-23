package code.code900.question872;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan
 * @version 1.0
 * @date 2020/5/7
 */
public class Solution {
    List<Integer> resu = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        getleaf(root1,res1);
        getleaf(root2,res2);
        return res1.equals(res2);
    }
    public void getleaf(TreeNode root,List<Integer> res){
        resu = res;
        dfs(root);
    }
    public void dfs(TreeNode root){
        if (root == null)return;
        if (root.left == null && root.right == null){
            resu.add(root.val);
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
