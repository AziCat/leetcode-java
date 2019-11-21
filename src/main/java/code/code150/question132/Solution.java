package code.code150.question132;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回符合要求的最少分割次数。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private int ans;
    private int temp = -1;
    private String s;
    private int length;

    /**
     * 中心扩展法
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        this.length = s.length();
        this.s = s;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < length; i++) {
            //单个字符为中心扩展
            centralExtend(dp, i, i);
            //两个字符为中心扩展
            centralExtend(dp, i, i + 1);
        }
        return dp[s.length() - 1];
    }

    private void centralExtend(int[] dp, int st, int en) {
        while (st >= 0 && en < length && s.charAt(st) == s.charAt(en)){
            dp[en] = Math.min(dp[en], st == 0 ? 0 : dp[st - 1] + 1);
            st--;
            en++;
        }
    }

    private int help(boolean[][] dp, int count, int st) {
        if (st < dp.length) {

        }
        return 0;
    }

    /**
     * 递归回溯超时
     *
     * @param s
     * @return
     */
    public int minCut_(String s) {
        this.ans = s.length();
        this.length = s.length();
        this.s = s;
        if (length != 0) {
            backtrack(0);
        }
        return ans;
    }

    private void backtrack(int st) {
        for (int i = length - 1; i >= st; i--) {
            if (isPalindromes(st, i)) {
                //如果是回文词
                addAns(i + 1);
                temp--;
            }
        }
    }

    private void addAns(int en) {
        temp++;
        if (en == length) {
            ans = Math.min(ans, temp);
        } else {
            backtrack(en);
        }
    }

    private boolean isPalindromes(int st, int en) {
        if (st == en) {
            return true;
        }
        while (st < en) {
            if (s.charAt(st) != s.charAt(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}
