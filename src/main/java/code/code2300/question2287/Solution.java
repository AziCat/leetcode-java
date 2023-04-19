package code.code2300.question2287;

/**
 * 给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
 * <p>
 * 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rearrange-characters-to-make-target-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/1/13
 */
public class Solution {
    public int rearrangeCharacters(String s, String target) {
        int ans = Integer.MAX_VALUE;
        int[] targetArr = new int[26];
        int[] sArr = new int[26];
        for (char c : s.toCharArray()) {
            sArr[c - 'a'] = sArr[c - 'a'] + 1;
        }
        for (char c : target.toCharArray()) {
            targetArr[c - 'a'] = targetArr[c - 'a'] + 1;
        }

        for (int i = 0; i < 26; i++) {
            if (targetArr[i] != 0) {
                ans = Math.min(ans, sArr[i] / targetArr[i]);
            }
        }
        return ans;
    }
}
