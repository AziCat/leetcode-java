package code.code450.question486;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/1
 */
public class Solution {
    /**
     * 动态规划
     * sum[k]表示num[0]+num[1]+...+num[k]
     * dp[i][j]为数组i~j区间先手能拿到的最大值，则另一个玩家拿到的分数为sum[j]-sum[i-1]-dp[i][j]
     * 状态转移方程为：
     * dp[i][j]=Max(num[i]+ sum[j]-sum[i-1]-dp[i+1][j] , num[j]+ sum[j]-sum[i-1]-dp[i][j-1])
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        //前缀和
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int row = 0;
            for (int col = row + i; col < nums.length; col++, row++) {
                if (col == row) {
                    dp[row][col] = nums[row];
                } else {
                    dp[row][col] = Math.max(
                            nums[row] + sum[col + 1] - sum[row + 1] - dp[row + 1][col],
                            sum[col] - sum[row] - dp[row][col - 1] + nums[col]
                    );
                }

            }
        }
        return dp[0][nums.length - 1] >= sum[nums.length] - dp[0][nums.length - 1];
    }
}
