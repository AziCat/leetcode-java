package code.code450.question423;

/**
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * <p>
 * 注意:
 * <p>
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 * 示例 1:
 * <p>
 * 输入: "owoztneoer"
 * <p>
 * 输出: "012" (zeroonetwo)
 * 示例 2:
 * <p>
 * 输入: "fviefuro"
 * <p>
 * 输出: "45" (fourfive)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/9/4
 */
public class Solution {
    public String originalDigits(String s) {
        char[] sChars = s.toCharArray();
        int[] cache = new int[26];
        for (char sChar : sChars) {
            cache[sChar - 'a']++;
        }
        int[] counter = new int[10];
        counter[0] = cache['z' - 'a'];
        counter[2] = cache['w' - 'a'];
        counter[4] = cache['u' - 'a'];
        counter[6] = cache['x' - 'a'];
        counter[8] = cache['g' - 'a'];

        counter[7] = cache['s' - 'a'] - counter[6];
        counter[3] = cache['h' - 'a'] - counter[8];
        counter[5] = cache['f' - 'a'] - counter[4];
        counter[9] = cache['i' - 'a'] - counter[5] - counter[6] - counter[8];
        counter[1] = cache['n' - 'a'] - counter[7] - counter[9] - counter[9];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counter.length; i++) {
            for (int j = 0; j < counter[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
