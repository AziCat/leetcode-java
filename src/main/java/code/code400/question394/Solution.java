package code.code400.question394;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/14
 */
public class Solution {
    public String decodeString(String s) {
        char[] sChars = s.toCharArray();
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder sub = new StringBuilder();
        for (char sChar : sChars) {
            if (sChar == '[') {
                stack.push(sub);
                sub = new StringBuilder();
            } else if (sChar == ']') {
                sub = helper(stack.pop(), sub);
            } else {
                sub.append(sChar);
            }
        }
        return sub.toString();
    }

    private StringBuilder helper(StringBuilder prefix, StringBuilder sub) {
        char[] chars = prefix.toString().toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                count = Integer.parseInt(prefix.substring(i));
                break;
            } else {
                sb.append(chars[i]);
            }
        }
        for (int i = 0; i < count; i++) {
            sb.append(sub);
        }
        return sb;
    }

}
