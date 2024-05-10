package code.code2400.question2385;

import common.TreeNode;

import java.util.Arrays;

/**
 * 2385. 感染二叉树需要的总时间
 *
 * @author yjh
 * @since 2024/4/24
 */
public class Solution {
    int ans = 0;
    int[] infected = new int[100001];

    public int amountOfTime(TreeNode root, int start) {
        Arrays.fill(infected, -1);
        //第0分钟被感染
        infected[start] = 0;
        infected(null, root, start, 0);
        return ans;
    }

    private int infected(TreeNode parent, TreeNode node, int start, int level) {
        int leftLevel = level;
        int rightLevel = level;
        if (null != node.left) {
            leftLevel = infected(node, node.left, start, level + 1);
        }
        if (null != node.right) {
            rightLevel = infected(node, node.right, start, level + 1);
        }
        if (infected[node.val] != -1) {
            return Math.max(level, Math.max(leftLevel, rightLevel));
        } else if (null != parent && infected[parent.val] != -1) {
            //上级被感染，本节点也被感染
            infected[node.val] = infected[parent.val] + 1;
            //左右子树最长路径为后续感染次数
            int max = Math.max(leftLevel, rightLevel);
            ans = Math.max(ans, infected[parent.val] + (max - level + 1));
        } else if (null != node.left && infected[node.left.val] != -1) {
            //左子树被感染，本节点也被感染
            infected[node.val] = infected[node.left.val] + 1;
            //右子树最长路径为后续感染次数
            ans = Math.max(ans, infected[node.val] + (rightLevel - level));
        } else if (null != node.right && infected[node.right.val] != -1) {
            //右子树被感染，本节点也被感染
            infected[node.val] = infected[node.right.val] + 1;
            //左子树最长路径为后续感染次数
            ans = Math.max(ans, infected[node.val] + (leftLevel - level));
        }
        return Math.max(level, Math.max(leftLevel, rightLevel));
    }
}
