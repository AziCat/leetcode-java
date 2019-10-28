package code.code100.question091;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/decode-ways
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/25
 */
public class Solution {
    /**
     * 使用动态规则
     * dp[i] 表示字符s长度为i时的解码数
     * i如果为0，说明只能与i-1组成一个字母，如果此时i与i-1不能组成字母则返回0；否则dp[i] = dp[i-2]
     * i如果不为0，说明i可以单独成一个字母，也可以与i-1组成一个字母，如果此时i与i-1不能组成字母则dp[i]=dp[i-1]，否则dp[i]=dp[i-1]+dp[i-2]
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '0') {
                    return 0;
                } else {
                    dp[i] = 1;
                }
            } else {
                if (s.charAt(i) == '0') {
                    if (isNotValid(s.charAt(i - 1), s.charAt(i))) {
                        return 0;
                    } else {
                        dp[i] = i >= 2 ? dp[i - 2] : 1;
                    }
                } else {
                    if (isNotValid(s.charAt(i - 1), s.charAt(i))) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    private boolean isNotValid(char a, char b) {
        return a <= '0' || (a == '2' && b > '6') || a > '2';
    }
}
