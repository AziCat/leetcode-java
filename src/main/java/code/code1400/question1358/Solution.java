package code.code1400.question1358;

/**
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * <p>
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 * 示例 2：
 * <p>
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-substrings-containing-all-three-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/5/7
 */
public class Solution {
    /**
     * 暴力法-超时
     *
     * @param s
     * @return
     */
    public int numberOfSubstrings1(String s) {
        int a, b, c, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            a = 0;
            b = 0;
            c = 0;
            for (int j = i; j < s.length(); j++) {
                char item = s.charAt(j);
                if (item == 'a') {
                    a++;
                } else if (item == 'b') {
                    b++;
                } else {
                    c++;
                }
                if (a >= 1 && b >= 1 && c >= 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int numberOfSubstrings(String s) {
        int answer = 0;
        //abc 的计数
        int[] count = new int[3];
        //窗口左沿
        int start = 0;
        //窗口右沿
        for (int end = 0; end < s.length(); end++) {
            char charAtEnd = s.charAt(end);
            count[charAtEnd - 'a']++;
            while (count[0] >= 1 && count[1] >= 1 && count[2] >= 1) {
                answer += s.length() - end;
                char charAtStart = s.charAt(start);
                count[charAtStart - 'a']--;
                start++;
            }
        }
        return answer;
    }

    /**
     * 指针
     *
     * @param s
     * @return
     */
    public int numberOfSubstrings2(String s) {
        int a = findNext(s, 0, 'a'), b = findNext(s, 0, 'b'), c = findNext(s, 0, 'c'), ans = 0;

        while (a != -1 && b != -1 && c != -1) {
            int begin = Math.min(a, Math.min(b, c));
            int end = Math.max(a, Math.max(b, c));
            ans += s.length() - end;
            if (a == begin) {
                a = findNext(s, begin + 1, 'a');
            } else if (b == begin) {
                b = findNext(s, begin + 1, 'b');
            } else {
                c = findNext(s, begin + 1, 'c');
            }
        }
        return ans;
    }

    private int findNext(String s, int st, char c) {
        int ans = -1;
        for (int i = st; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == c) {
                return i;
            }
        }
        return ans;
    }
}
