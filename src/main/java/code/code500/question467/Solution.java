package code.code500.question467;

/**
 * @author yjh
 * @since 2022/1/27
 */
public class Solution {
    /**
     * maxEnd[i]记录以某字母结尾的子串最大个数
     * dp[i]记录当前位置以该字母结尾的子串最大个数
     *
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        if (null == p || p.length() == 0) {
            return 0;
        }
        int ans = 0;
        int[] maxEnd = new int[26];
        int[] dp = new int[p.length()];
        char[] pChar = p.toCharArray();
        for (int i = 0; i < pChar.length; i++) {
            if (i == 0) {
                maxEnd[pChar[i] - 'a'] = 1;
                dp[i] = 1;
            } else {
                //判断前一个字母是否符合abcd...za...的顺序
                char pre = pChar[i - 1];
                char cur = pChar[i];
                if (('z' == pre && 'a' == cur) || pre + 1 == cur) {
                    //连续字符，计算以cur结尾子串个数
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
                //更新最大值
                maxEnd[cur - 'a'] = Math.max(dp[i], maxEnd[cur - 'a']);
            }
        }
        for (int i : maxEnd) {
            ans += i;
        }
        return ans;
    }
}
