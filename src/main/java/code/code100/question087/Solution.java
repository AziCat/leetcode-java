package code.code100.question087;

/**
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。\
 * 示例 1:
 * <p>
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/24
 */
public class Solution {
    //参考答案：https://leetcode-cn.com/problems/scramble-string/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-2/
    //解法2，动态规划

    /**
     * dp[len][i][j] 表示s1.substring(i,i+len) 与 s2.substring(j,j+len) 是否为扰乱字符串
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        if (length == 0) {
            return true;
        }
        if (length != s2.length()) {
            return false;
        }
        boolean[][][] dp = new boolean[length + 1][length][length];
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i + len <= length; i++) {
                for (int j = 0; j + len <= length; j++) {
                    if (len == 1) {
                        dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        int q = 1;
                        while (q < len) {
                            if (dp[len][i][j]) {
                                break;
                            } else {
                                dp[len][i][j] = (dp[q][i][j] && dp[len - q][i + q][j + q]) || (dp[q][i][len - q + j] && dp[len - q][i + q][j]);
                            }
                            q++;
                        }
                    }

                }
            }
        }
        return dp[length][0][0];
    }
}
