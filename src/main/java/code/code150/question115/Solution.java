package code.code150.question115;

import java.util.Arrays;

/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * <p>
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "rabbbit", T = "rabbit"
 * <p>
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 */
public class Solution {
    public int numDistinct(String s, String t) {
        // dp[0]表示空串
        int[] dp = new int[t.length() + 1];
        // dp[0]永远是1，因为不管S多长，都只能找到一个空串，与T相等
        dp[0] = 1;

        //t的字典
        int[] map = new int[128];
        Arrays.fill(map, -1);

        //从尾部遍历的时候可以遍历 next类似链表 无重复值时为-1，
        //有重复时例如从rabbit的b开始索引在map[b] = 2 next[2] 指向下一个b的索引为3
        // for (int j = t.length() - 1; j >= 0; j--) {
        //     if (t.charAt(j) == s.charAt(i)) {
        //        dp[j + 1] += dp[j];
        //     }
        // }
        //这段代码的寻址就可以从map[s.charAt(i)] 找到索引j 在用next[j] 一直找和 s.charAt(i)相等的字符 其他的就可以跳过了
        //所以这个代码的优化 关键要理解 上面的一维倒算
        int[] nexts = new int[t.length()];
        for(int i = 0 ; i < t.length(); i++){
            int c = t.charAt(i);
            nexts[i] = map[c];
            map[c] = i;
        }

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            for(int j = map[c]; j >= 0; j = nexts[j]){
                dp[j + 1] += dp[j];
            }
        }
        return dp[t.length()];
    }
    /**
     * 使用动态规划，dp[i][j]表示字符t从0到i-1的位置，作为字符s从0到j-1的位置子序列出现的次数
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct_(String s, String t) {
        if (s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[t.length()][s.length()];
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = t.charAt(i) == s.charAt(j) ? 1 : 0;
                } else if (i == 0) {
                    dp[i][j] = t.charAt(i) == s.charAt(j) ? dp[i][j - 1] + 1 : dp[i][j - 1];
                } else if (j != 0) {
                    dp[i][j] = t.charAt(i) == s.charAt(j) ? dp[i][j - 1] + dp[i - 1][j - 1] : dp[i][j - 1];
                }
            }
        }
        return dp[t.length() - 1][s.length() - 1];
    }
}
