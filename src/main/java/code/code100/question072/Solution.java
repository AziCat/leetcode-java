package code.code100.question072;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 链接：https://leetcode-cn.com/problems/edit-distance
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/18
 */
public class Solution {
    /**
     * 使用动态规则
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
                } else if (i == 0) {
                    dp[i][j] = word1.charAt(i) == word2.charAt(j) ? j : dp[i][j - 1] + 1;
                } else if (j == 0) {
                    dp[i][j] = word1.charAt(i) == word2.charAt(j) ? i : dp[i - 1][j] + 1;
                } else {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
        }
        return dp[word1.length() - 1][word2.length() - 1];
    }
}
