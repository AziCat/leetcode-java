package code.code2650.question2639;

/**
 * @author yjh
 * @since 2024/4/28
 */
public class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int[] row : grid) {
            for (int i = 0; i < row.length; i++) {
                dp[i] = Math.max(dp[i], String.valueOf(row[i]).length());
            }
        }
        return dp;
    }
}
