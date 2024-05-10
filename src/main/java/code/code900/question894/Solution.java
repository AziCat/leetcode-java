package code.code900.question894;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 所有可能的真二叉树
 *
 * @author yjh
 * @since 2024/4/3
 */
public class Solution {

    private final List<TreeNode>[] dp = new List[20];

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return Collections.emptyList();
        }
        if (n == 1) {
            dp[1] = Collections.singletonList(new TreeNode(0));
        }
        if (null != dp[n]) {
            return dp[n];
        }
        int leftCounter = 1;
        int rightCounter = n - leftCounter - 1;
        List<TreeNode> result = new ArrayList<TreeNode>();
        while (rightCounter >= 0) {
            List<TreeNode> leftNodes = allPossibleFBT(leftCounter);
            List<TreeNode> rightNodes = allPossibleFBT(rightCounter);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
            leftCounter += 2;
            rightCounter = n - leftCounter - 1;
        }
        dp[n] = result;
        return result;
    }
}
