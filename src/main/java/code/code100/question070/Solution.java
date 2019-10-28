package code.code100.question070;

/**
 * @author yan
 * @version 1.0
 * @date 2019/10/21
 */
public class Solution {

    /**
     * 使用动态规划,dp[n]表示到n层楼梯有多少种方法；因为每次可以跳1层或者跳2层，跳1层到达n有dp[n-1]种方法，跳2层到达n有dp[n-2]种方法
     * 所以有dp[n] = dp[n-1]+dp[n-2]
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i < 4) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
