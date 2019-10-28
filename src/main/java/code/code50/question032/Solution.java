package code.code50.question032;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/24
 */
public class Solution {
    /**
     * 在这种方法中，我们利用两个计数器 left 和 right 。
     * 从左向右遍历字符，遇到'('时left++，遇到')'时right++。
     * 当right大于left时，清空计数器。
     * 当right等于left时，计算当前长度。
     * <p>
     * 再从右到左来一次
     * <p>
     * 2 ms	36.9 MB
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int ans = 0;
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ('(' == aChar) {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                left = 0;
                right = 0;
            } else if (right == left) {
                ans = Math.max(ans, right + left);
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return ans;
    }

    /**
     * 使用动态规划
     * <p>
     * 定义数组dp，长度与s一致，初始化为0，dp[i]记录当前s[i]有效长度，因为有效的s[i]总以')'结尾，所以'('总为0
     * <p>
     * 两两字符遍历
     * <p>
     * 如果 s[i-1]='('且s[i]=')' --> ....()
     * 则得出 dp[i] =  dp[i-2] + 2
     * <p>
     * 如果 s[i-1]=')'且s[i]=')' --> ....))
     * 且满足 s[i- dp[i-1] - 1] = '(' --> ....(xxx))   xxx)为有效子串
     * 则得出 dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
     * <p>
     * 2 ms	37.8 MB
     *
     * @param s
     * @return
     */
    public int longestValidParentheses___(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == '(' && chars[i] == ')') {
                if (i - 2 < 0) {
                    dp[i] = 2;
                } else {
                    dp[i] = dp[i - 2] + 2;
                }
            } else if (chars[i - 1] == ')' && chars[i] == ')') {
                if (i - dp[i - 1] - 1 >= 0) {
                    if (chars[i - dp[i - 1] - 1] == '(') {
                        if (i - dp[i - 1] - 2 < 0) {
                            dp[i] = dp[i - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 使用栈得出闭合区间的坐标，出栈时即计算距离
     * <p>
     * 4 ms	37.5 MB
     *
     * @param s
     * @return
     */
    public int longestValidParentheses__(String s) {
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(-1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.addLast(i);
            } else {
                stack.pollLast();
                if (stack.isEmpty()) {
                    stack.addLast(i);
                } else {
                    ans = Math.max(ans, i - stack.peekLast());
                }
            }
        }
        return ans;
    }

    /**
     * 先使用栈得出闭合区间的坐标，再把坐标放到优先队列，最后从优先队列中得出最长的连贯区间长度
     * <p>
     * 61 ms	37.3 MB
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_(String s) {
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> i));
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.addLast(i);
            } else {
                Integer index = stack.pollLast();
                if (null != index) {
                    priorityQueue.add(index);
                    priorityQueue.add(i);
                }
            }
        }
        int counter = 1;
        while (!priorityQueue.isEmpty()) {
            Integer head = priorityQueue.poll();
            Integer next = priorityQueue.peek();
            if (null != next && next - head == 1) {
                counter += 1;
            } else {
                counter = 1;
            }
            ans = Math.max(ans, counter);
        }

        return ans;
    }
}
