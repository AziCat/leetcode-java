package code.code400.question395;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aaabb", k = 3
 * <p>
 * 输出:
 * 3
 * <p>
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 * <p>
 * 输入:
 * s = "ababbc", k = 2
 * <p>
 * 输出:
 * 5
 * <p>
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/20
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        char[] sChars = s.toCharArray();
        return longestSubstring(sChars, 0, sChars.length - 1, k);
    }

    private int longestSubstring(char[] sChars, int l, int r, int k) {
        if (l < 0 || r >= sChars.length || l > r || r - l + 1 < k) {
            return 0;
        }
        int ans = 0;
        //计算各个字母个数
        int[] counter = new int[26];
        for (int i = l; i <= r; i++) {
            counter[sChars[i] - 'a']++;
        }
        //以小于k的字母分隔，计算各个区间
        int left = l;
        boolean flag = true;
        for (int i = l; i <= r; i++) {
            if (counter[sChars[i] - 'a'] < k) {
                flag = false;
                ans = Math.max(ans, longestSubstring(sChars, left, i - 1, k));
                left = i + 1;
            }
        }
        //全都不小于k，直接返回
        if (flag) {
            return r - l + 1;
        }
        //计算最后一个区间
        if (left != r + 1) {
            ans = Math.max(ans, longestSubstring(sChars, left, r, k));
        }
        return ans;
    }
}
