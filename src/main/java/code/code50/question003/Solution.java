package code.code50.question003;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/10
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("abc".charAt(0));
    }

    public int lengthOfLongestSubstring(String s) {
        if (null != s && !"".equals(s)) {
            int start = 0;
            int max = 0;
            int length = s.length();
            Map<Character, Integer> map = new HashMap<>(16);
            for (int end = 0; end < length; end++) {
                Character c = s.charAt(end);
                if (map.containsKey(c)) {
                    start = Math.max(map.get(c), start);
                }
                map.put(c, end + 1);
                max = Math.max(max, end - start + 1);
            }
            return max;
        }
        return 0;
    }

    public int lengthOfLongestSubstring0(String s) {
        if (null != s && !"".equals(s)) {
            int max = 1;
            StringBuilder sb = new StringBuilder(s.substring(0, 1));
            for (int i = 1; i < s.length(); i++) {
                //判断sb中是否包含下一个字母，如果不包含，添加到sb中。
                String nextStr = s.substring(i, i + 1);
                if (!sb.toString().contains(nextStr)) {
                    sb.append(nextStr);
                } else {
                    //如果包含，截取该字母后面的内容作为sb
                    int startIndex = sb.indexOf(nextStr) + 1;
                    int endIndex = sb.length();
                    sb = new StringBuilder(sb.substring(startIndex, endIndex)).append(nextStr);
                }
                //比较max值与当前sb字符长度，把最大值设置到max中
                max = sb.length() > max ? sb.length() : max;
            }
            return max;
        }
        return 0;
    }
}
