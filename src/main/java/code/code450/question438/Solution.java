package code.code450.question438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/10/14
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        //记录p各个字符个数
        int[] cache = new int[26];
        //记录s各个字符个数
        int[] temp = new int[26];
        for (char c : p.toCharArray()) {
            cache[c - 'a']++;
        }
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        while (left < chars.length && right < chars.length) {
            char c = chars[right];
            temp[c - 'a']++;
            right++;
            if (temp[c - 'a'] > cache[c - 'a']) {
                //如果超出个数，左指针右移直到个数相等
                while (chars[left] != c) {
                    temp[chars[left] - 'a']--;
                    left++;
                }
                temp[chars[left] - 'a']--;
                left++;
            } else if (temp[c - 'a'] == cache[c - 'a'] && right - left == p.length()) {
                //个数相等且长度相等
                ans.add(left);
                temp[chars[left] - 'a']--;
                left++;
            }
        }
        return ans;
    }
}
