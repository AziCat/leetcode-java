package code.code50.question044;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * <p>
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/30
 */
public class Solution {
    /**
     * 动态规划
     * 17 ms	39 MB
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[0][0] = true;
                    } else {
                        dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
                    }
                } else {
                    if (j == 0) {
                        dp[i][0] = false;
                    } else {
                        if ((s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1]) {
                            dp[i][j] = true;
                        } else if (p.charAt(j - 1) == '*' && (dp[i - 1][j] || dp[i][j - 1])) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * 指针实现
     * <p>
     * 4 ms	37.7 MB
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        if (s.length() == 0) {
            return p.equals("*") || p.equals(s);
        }
        int sI = 0, pI = 0, xI = -1, rI = -1;
        boolean matchIng = false;
        while (sI < s.length()) {
            while (pI < p.length() && p.charAt(pI) == '*') {
                xI = pI;
                pI++;
                matchIng = true;
            }
            if (pI < p.length() && (s.charAt(sI) == p.charAt(pI) || p.charAt(pI) == '?')) {
                if (matchIng) {
                    rI = sI;
                }
                sI++;
                pI++;
                matchIng = false;
            } else {
                if (matchIng) {
                    sI++;
                } else {
                    if (xI != -1 && rI != -1) {
                        pI = xI;
                        sI = rI + 1;
                        rI = -1;
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int i = pI; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                pI++;
            }
        }
        return pI == p.length() && sI == s.length();
    }
}
