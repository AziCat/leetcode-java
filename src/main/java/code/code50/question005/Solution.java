package code.code50.question005;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/10
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("cbbd".substring(1, 2));
    }

    private int getLen(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            len = right - left;
            left--;
            right++;
        }
        return len + 1;
    }

    public String longestPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = getLen(s, i, i + 1);
            int len2 = getLen(s, i, i + 2);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                if (len1 > len2) {
                    start = i - (len1 - 2) / 2;
                    end = i + 2 + (len1 - 2) / 2;
                } else {
                    start = i - (len2 - 3) / 2;
                    end = i + 3 + (len2 - 3) / 2;
                }
            }


        }

        return s.length() == 1 ? s : s.substring(start, end);
    }
}
