package code.code350.question322;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/3/23
 */
public class Solution {


    /**
     * 动态规划
     * coins = [1, 2, 5], amount = 11
     * dp[11]=dp[10]+1或者dp[9]+1或者dp[6}+1
     * 要求dp[11]为最小，则动态转移方程如下
     * dp[amount] = Min(dp[amount-c1],dp[amount-c2]....dp[amount-cn])+1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //应对特殊测试用例。。。
        if (amount < 1) {
            return 0;
        }
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i == coin) {
                    dp[i] = 1;
                } else if (i > coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }


}
