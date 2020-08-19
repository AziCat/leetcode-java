package code.code400.question387;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 *  
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/13
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];

        char[] array = s.toCharArray();
        for (char c : array) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[array[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
