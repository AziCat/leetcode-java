package code.code450.question409;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/26
 */
public class Solution {
    public int longestPalindrome(String s) {
        int counter = 0;
        int[] set = new int[128];
        int ans = 0;
        char[] sChars = s.toCharArray();
        for (char sChar : sChars) {
            if (set[sChar] == 1) {
                set[sChar] -= 1;
                counter--;
                ans += 2;
            } else {
                set[sChar] += 1;
                counter++;
            }
        }
        if (counter != 0) {
            ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println('z' + 0);
        System.out.println('Z' + 0);
    }
}