package code.code350.question316;

import java.util.Stack;

/**
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 * <p>
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/3/17
 */
public class Solution {
    /**
     * 利用栈
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        //记录某字母是否在栈中
        boolean[] stackContain = new boolean[26];
        Stack<Character> stack = new Stack<>();
        // 记录每个字符出现的最后一个位置
        int[] lastAppearIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastAppearIndex[s.charAt(i) - 'a'] = i;
        }
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            //如果栈中已存在，跳过
            if (stackContain[currentChar - 'a']) {
                continue;
            }

            //如果当前字母小于栈顶，且栈顶会在后面出现，栈顶出栈
            while (!stack.empty() && stack.peek() > currentChar && lastAppearIndex[stack.peek() - 'a'] >= i) {
                char top = stack.pop();
                stackContain[top - 'a'] = false;
            }

            stack.push(currentChar);
            stackContain[currentChar - 'a'] = true;

        }
        char[] ans = new char[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return new String(ans);
    }
}
