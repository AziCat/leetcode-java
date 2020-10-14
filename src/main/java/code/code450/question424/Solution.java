package code.code450.question424;

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * @author yan
 * @version 1.0
 * @date 2020/9/8
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        //记录字母出现次数
        int[] count = new int[26];
        //双指针划定一个区间，maxCount为区间内出现次数最多字母的数量
        int left = 0, right = 0, maxCount = 1, ans = 0;
        char[] chars = s.toCharArray();
        count[chars[right] - 'A']++;
        while (right < chars.length) {
            int len = right - left + 1;
            if (len - maxCount > k) {
                //如果区间长度-maxCount大于k，说明不能通过替换k次使全部字母重复，需要把左指针右移，缩小范围
                count[chars[left] - 'A']--;
                left++;
            } else {
                ans = Math.max(len, ans);
                right++;
                if (right < chars.length) {
                    maxCount = Math.max(maxCount, ++count[chars[right] - 'A']);
                }
            }
        }
        return ans;
    }
}
