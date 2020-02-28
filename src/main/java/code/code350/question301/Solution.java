package code.code350.question301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * <p>
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 * <p>
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 * <p>
 * 输入: ")("
 * 输出: [""]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/28
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        //先计算错误的左括号和右括号数量
        int left = 0, right = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        HashSet<String> set = new HashSet<>();
        set.add(s);
        //删除左括号
        set = removeParenthesis(set, '(', left);
        //删除右括号
        set = removeParenthesis(set, ')', right);
        for (String subStr : set) {
            if (check(subStr)) {
                ans.add(subStr);
            }
        }
        return ans;
    }

    private boolean check(String s) {
        int left = 0, right = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
            if (right > left) {
                return false;
            }
        }
        return left == 0;
    }

    private HashSet<String> removeParenthesis(HashSet<String> setTemp, char parenthesis, int counter) {
        if (counter == 0) {
            return setTemp;
        }
        HashSet<String> set = new HashSet<>();
        //删除左括号
        while (counter > 0) {
            set.clear();
            for (String subStr : setTemp) {
                for (int i = 0; i < subStr.length(); i++) {
                    if (subStr.charAt(i) == parenthesis) {
                        set.add(subStr.substring(0, i) + subStr.substring(i + 1));
                    }
                }
            }
            counter--;
            setTemp = new HashSet<>(set);
        }
        return set;
    }
}
