package code.code1250.question1218;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/11/5
 */
public class Solution {
    /**
     * 超时
     *
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence1(int[] arr, int difference) {
        int ans = 1;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + difference == arr[j]) {
                    //满足等差
                    if (dp[i] >= dp[j]) {
                        dp[j] = dp[i] + 1;
                        ans = Math.max(ans, dp[j]);
                        break;
                    }
                }
            }
        }
        return ans;
    }


    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        //dp[k]是以k为结尾的最大长度，因为-10000<=k，difference<=10000
        int[] dp = new int[40001];
        for (int value : arr) {
            value += 20000;
            int pre = value - difference;
            dp[value] = dp[pre] + 1;
            ans = Math.max(ans, dp[value]);
        }
        return ans;
    }
}
