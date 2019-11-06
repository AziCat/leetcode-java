package code.code100.question096;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树
 * <p>
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 */
public class Solution {
    /**
     * 动态规划
     * 假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            int s = 0;
            while (s < i) {
                dp[i] += dp[s] * dp[i - s - 1];
                s++;
            }
        }
        return dp[n];
    }
    /**
     * 可以参考question095的解法，当i作为根节点，左子树由1~i-1构成，右子树由i+1~n构成
     * 此方法超时
     *
     * @param n
     * @return
     */
    public int numTrees_(int n) {
        if (n < 1) {
            return 0;
        }
        return numTrees(1, n);
    }

    private int numTrees(int s, int e) {
        int count = 0;
        if (s > e) {
            return 1;
        } else {
            for (int i = s; i <= e; i++) {
                int leftTreeNums = numTrees(s, i - 1);
                int rightTreeNums = numTrees(i + 1, e);
                count = count + leftTreeNums * rightTreeNums;
            }
            return count;
        }
    }
}
