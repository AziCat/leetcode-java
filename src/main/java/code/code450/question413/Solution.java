package code.code450.question413;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/1
 */
public class Solution {
    /**
     * 使用动态规划
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int ans = 0;
        //temp=A[i]-A[i-1]，用于判断是否等差数列
        int temp = A[1] - A[0];
        //dp[i]用于记录满足temp[i]的等差子数组长度
        int[] dp = new int[A.length];
        dp[0] = 1;
        for (int i = 1; i < A.length; i++) {
            if (temp == A[i] - A[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                temp = A[i] - A[i - 1];
                dp[i] = 2;
            }
            ans += (dp[i] - 2);
        }
        return ans;
    }
}
