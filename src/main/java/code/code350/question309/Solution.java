package code.code350.question309;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/3/2
 */
public class Solution {
    /**
     * 动态规划
     * dp[0][k]:第k天，无持有
     * 状态转换：
     * 1、卖出 dp[1][k-1] + prices[k]
     * 2、无操作 dp[0][k-1]
     * <p>
     * dp[1][k]：第k天，持有
     * 状态转换：
     * 1、买入 dp[0][k-2]-prices[k]
     * 2、无操作 dp[1][k-1]
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[2][prices.length];
        for (int k = 0; k < prices.length; k++) {
            if (k == 0) {
                dp[1][k] = -prices[k];
            } else if (k == 1) {
                dp[1][k] = Math.max(-prices[k], dp[1][k - 1]);
                dp[0][k] = Math.max(dp[1][k - 1] + prices[k], dp[0][k - 1]);
            } else {
                dp[1][k] = Math.max(dp[0][k - 2] - prices[k], dp[1][k - 1]);
                dp[0][k] = Math.max(dp[1][k - 1] + prices[k], dp[0][k - 1]);
            }
        }

        return dp[0][prices.length - 1];
    }

}
