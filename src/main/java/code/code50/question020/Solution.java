package code.code50.question020;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/17
 */
public class Solution {
    /**
     * 使用栈3
     * 1 ms	34.1 MB
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        if (length % 2 == 1) {
            return false;
        }
        Character[] stack = new Character[length];
        int index = -1;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack[++index] = c;
                    break;
                case ')':
                    if (index == -1 || stack[index] != '(') {
                        return false;
                    } else {
                        index--;
                    }
                    break;
                case ']':
                    if (index == -1 || stack[index] != '[') {
                        return false;
                    } else {
                        index--;
                    }
                    break;
                case '}':
                    if (index == -1 || stack[index] != '{') {
                        return false;
                    } else {
                        index--;
                    }
                    break;
                default:
                    return false;
            }
        }
        return index == -1;
    }

    /**
     * 使用栈2
     * 7 ms	35.2 MB
     *
     * @param s
     * @return
     */
    public boolean isValid__(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                //弹出栈顶元素，如果为空则入栈
                Character top = stack.peek();
                if (null == top) {
                    stack.push(c);
                } else {
                    //判断是否闭合，如果是则出栈，否则继续入栈
                    if (check(top, c)) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 使用栈1
     * 4 ms	35.1 MB
     *
     * @param s
     * @return
     */
    public boolean isValid_(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            //弹出栈顶元素，如果为空则入栈
            Character top = stack.peekLast();
            if (null == top) {
                stack.add(c);
            } else {
                //判断是否闭合，如果是则出栈，否则继续入栈
                if (check(top, c)) {
                    stack.pollLast();
                } else {
                    stack.add(c);
                }
            }
        }
        return stack.size() == 0;
    }

    private boolean check(Character c1, Character c2) {
        switch (c1) {
            case '(':
                return ')' == c2;
            case '{':
                return '}' == c2;
            case '[':
                return ']' == c2;
            default:
                return false;

        }
    }

    public static void main(String[] args) {
        Character c1 = '(', c2 = '(';
        System.out.println(c1.equals(c2));
    }
}
