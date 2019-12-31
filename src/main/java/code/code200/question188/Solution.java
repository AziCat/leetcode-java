package code.code200.question188;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 * <p>
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/25
 */
public class Solution {
    /**
     * 动态规则dp[i][k][j]代表利润
     * i:第i天
     * k:第k次交易
     * j：1持有股票，0清仓
     * 状态转移方程
     * 持有状态：通过买入或者保持昨天持有状态 dp[i][k][1] = (dp[i-1][k-1][0] - prices[i] 或者 dp[i-1][k][1])
     * 清仓状态：通过卖出或者保持昨天清仓状态 dp[i][k][0] = (dp[i-1][k][1] + prices[i] 或者 dp[i-1][k][0])
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        //当k太大会超出内存限制，因为规定只有清仓才可以进行下次交易，所以k>n/2时忽略k值的影响
        if (k > n / 2) {
            return maxProfitUnLimit(prices);
        }
        int[][][] dp = new int[n + 1][k + 1][2];
        for (int i = 1; i <= n; i++) {
            for (int K = 0; K <= k; K++) {
                if (K == 0) {
                    //没有交易，利润为0
                    dp[i][0][0] = 0;
                    continue;
                }
                if (i == 1) {
                    //第一天，忽略交易次数，持有股票则利润为-prices[i-1]
                    dp[i][K][0] = 0;
                    dp[i][K][1] = -prices[i - 1];
                    continue;
                }
                //清仓：卖出或者不操作
                dp[i][K][0] = Math.max(dp[i - 1][K][1] + prices[i - 1], dp[i - 1][K][0]);
                //买入：买入或者不操作
                dp[i][K][1] = Math.max(dp[i - 1][K - 1][0] - prices[i - 1], dp[i - 1][K][1]);
            }
        }
        return dp[n][k][0];
    }

    /**
     * 持有状态：通过买入或者保持昨天持有状态 dp[i][1] = (dp[i-1][0] - prices[i] 或者 dp[i-1][1])
     * 清仓状态：通过卖出或者保持昨天清仓状态 dp[i][0] = (dp[i-1][1] + prices[i] 或者 dp[i-1][0])
     *
     * @param prices
     * @return
     */
    private int maxProfitUnLimit(int[] prices) {
        int dp_i_1 = -prices[0];
        int dp_i_0 = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_1 + prices[i], dp_i_0);
            dp_i_1 = Math.max(temp - prices[i], dp_i_1);
        }
        return dp_i_0;
    }
}
