package code.code400.question389;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * <p>
 * 输出：
 * e
 * <p>
 * 解释：
 * 'e' 是那个被添加的字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/13
 */
public class Solution {
    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 71.22%
     * 内存消耗：
     * 37.8 MB
     * , 在所有 Java 提交中击败了
     * 74.58%
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference_(String s, String t) {
        int[] counter = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (char sChar : sChars) {
            counter[sChar - 'a']++;
        }
        for (char tChar : tChars) {
            if (counter[tChar - 'a'] == 0) {
                return tChar;
            }
            counter[tChar - 'a']--;
        }
        return 'a';
    }

    /**
     * 相同值做^运算等于0
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans ^= t.charAt(i);
            ans ^= s.charAt(i);
        }
        ans ^= t.charAt(t.length() - 1);
        return ans;
    }
}