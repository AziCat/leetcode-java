package code.code100.question058;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/12
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int ans = 0;
        int pointer = length - 1;
        while (pointer > -1) {
            if (s.charAt(pointer) != ' ') {
                ans++;
                pointer--;
            } else {
                if (pointer != length - 1 && s.charAt(pointer + 1) != ' ') {
                    break;
                }
                pointer--;
            }
        }
        return ans;
    }
}
