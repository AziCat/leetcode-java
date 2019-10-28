package code.code100.question076;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/21
 */
public class Solution {
    public String minWindow__(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int count = t.length();
        int minLen = Integer.MAX_VALUE, l = 0, r = 0;
        int i = 0, j = 0;
        while (j < s.length()) {

            if (map[s.charAt(j++)]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (j - i < minLen) {
                    minLen = j - i;
                    l = i;
                    r = j;
                }
                if (++map[s.charAt(i++)] > 0) {
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(l, r);
    }

    public String minWindow(String s, String t) {
        int start = 0, minLength = Integer.MAX_VALUE, left = 0, right = 0;
        int[] tMap = new int[124];
        int count = t.length();
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }
        while (right < s.length()) {
            if (tMap[s.charAt(right)]-- > 0) {
                count--;
            }
            //如果窗口包含所有字母，窗口左侧开始右移
            while (count == 0) {
                if (right - left < minLength) {
                    start = left;
                    minLength = right - left;
                }
                if (++tMap[s.charAt(left++)] > 0) {
                    count++;
                }
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength + 1);
    }


    public String minWindow_(String s, String t) {
        String ans = "";
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.merge(c, 1, (a, b) -> a + b);
        }
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = -1, right = 0;
        while (right < s.length()) {
            if (tMap.containsKey(s.charAt(right))) {
                if (left == -1) {
                    left = right;
                }
                windowMap.merge(s.charAt(right), 1, (a, b) -> a + b);
                if (isContain(tMap, windowMap)) {
                    //判断窗口左边能否右移
                    left = leftMoveRight(windowMap, tMap, left, s);
                    if ("".equals(ans) || right - left < ans.length()) {
                        ans = s.substring(left, right + 1);
                    }
                }
            }
            right++;
        }
        return ans;
    }

    private int leftMoveRight(Map<Character, Integer> windowMap, Map<Character, Integer> tMap, int left, String s) {
        windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) - 1);
        if (isContain(tMap, windowMap)) {
            left++;
            while (!tMap.containsKey(s.charAt(left))) {
                left++;
            }
            return leftMoveRight(windowMap, tMap, left, s);
        } else {
            windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) + 1);
            return left;
        }

    }

    private boolean isContain(Map<Character, Integer> tMap, Map<Character, Integer> windowMap) {
        for (Character c : tMap.keySet()) {
            if (!windowMap.containsKey(c)) {
                return false;
            } else {
                if (windowMap.get(c) < tMap.get(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
