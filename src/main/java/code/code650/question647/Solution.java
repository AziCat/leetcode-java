package code.code650.question647;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/19
 */
public class Solution {
    private int ans = 0;

    public int countSubstrings(String s) {
        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            //以当前位置为中心点检查
            check(i, i, sChars);
            //以当前位置与当前位置右侧为中心检查
            check(i, i + 1, sChars);
        }
        return ans;
    }

    private void check(int l, int r, char[] sChars) {
        while (l >= 0 && r < sChars.length) {
            if (sChars[l] == sChars[r]) {
                ans++;
                l--;
                r++;
            } else {
                break;
            }
        }
    }
}
