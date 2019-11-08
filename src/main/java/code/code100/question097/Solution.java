package code.code100.question097;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * <p>
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 */
public class Solution {
    private boolean ans = false;

    /**
     * 使用回溯算法
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int p1 = 0, p2 = 0;
        backtrack(p1, p2, s1, s2, s3);
        return ans;
    }

    private void backtrack(int p1, int p2, String s1, String s2, String s3) {
        if (p1 + p2 == s3.length()) {
            ans = true;
            return;
        }
        if (p1 + p2 < s3.length()) {
            if (p1 < s1.length() && s1.charAt(p1) == s3.charAt(p1 + p2)) {
                p1++;
                backtrack(p1, p2, s1, s2, s3);
                if (ans) {
                    return;
                } else {
                    p1--;
                }
            }
            if (p2 < s2.length() && s2.charAt(p2) == s3.charAt(p1 + p2)) {
                p2++;
                backtrack(p1, p2, s1, s2, s3);
                if (ans) {
                    return;
                } else {
                    p2--;
                }
            }
        }
    }

    /**
     * 使用动态规划，dp[i][j]表示 s1从0~i-1与s2从0~j-1能否交错成s3 0~i+j-1
     * 动态方程：
     * i=0&&j>0时 dp[0][j] = dp[i][j-1]&&s2[j-1]==s3[i+j-1]
     * j=0&&i>0时 dp[i][0] = dp[i-1][j]&&s1[i-1]==s3[i+j-1]
     * 否则 dp[i][j] = dp[i][j-1]&&s2[j-1]==s3[i+j-1] || dp[i-1][j]&&s1[i-1]==s3[i+j-1]
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave_(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) || dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
