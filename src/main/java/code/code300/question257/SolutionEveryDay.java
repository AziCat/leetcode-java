package code.code300.question257;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/4
 */
public class SolutionEveryDay {
    private final List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (null != root) {
            build(new StringBuilder(), root);
        }
        return ans;
    }

    private void build(StringBuilder sb, TreeNode root) {
        sb.append(root.val);
        if (null != root.left) {
            build(new StringBuilder().append(sb).append("->"), root.left);
        }
        if (null != root.right) {
            build(new StringBuilder().append(sb).append("->"), root.right);
        }
        if (null == root.left && null == root.right) {
            ans.add(sb.toString());
        }
    }
}
