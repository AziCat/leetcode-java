package code.code1050.question1043;

/**
 * @author yjh
 * @since 2023/4/19
 */
public class Solution {
    /**
     * 1 <= arr.length <= 500
     * 0 <= arr[i] <= 10^9
     * 1 <= k <= arr.length
     *
     * @param arr arr
     * @param k   k
     * @return int
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            int cur = i;
            int counter = 1;
            int max = 0;
            while (cur >= 0 && counter <= k) {
                max = Math.max(arr[cur], max);
                dp[i + 1] = Math.max(dp[cur] + counter * max, dp[i + 1]);
                cur--;
                counter++;
            }
        }
        return dp[arr.length];
    }
}
