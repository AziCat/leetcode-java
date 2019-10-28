package code.code50.question022;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/18
 */
public class Solution {


    /**
     * 递归回溯优化，减少了字符串的创建拼接
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] stringArr = new char[n * 2];
        buildAns(stringArr, 0, 0, 0, ans, n);
        return ans;
    }

    private void buildAns(char[] stringArr, int index, int openNum, int closeNum, List<String> ans, int n) {
        if (openNum == n && closeNum == openNum) {
            ans.add(new String(stringArr));
        }
        if (closeNum > openNum) {
            return;
        }
        if (openNum < n) {
            stringArr[index] = '(';
            buildAns(stringArr, index + 1, openNum + 1, closeNum, ans, n);
        }
        if (closeNum < n) {
            stringArr[index] = ')';
            buildAns(stringArr, index + 1, openNum, closeNum + 1, ans, n);
        }


    }


    /**
     * 递归回溯
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis_(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, ans, "", 0, 0);
        return ans;
    }

    /**
     * count1记录左括号数，count2记录右括号数
     *
     * @param n
     * @param ans
     * @param seed
     * @param count1
     * @param count2
     */
    private void generateParenthesis(int n, List<String> ans, String seed, int count1, int count2) {
        //当超过n个括号直接退出递归
        if (count1 > n || count2 > n) {
            return;
        }
        //当右括号比左括号多直接退出递归
        if (count1 < count2) {
            return;
        }
        //当左右括号数相等且字符长度满足
        if (count1 == count2 && seed.length() == 2 * n) {
            ans.add(seed);
        }
        generateParenthesis(n, ans, seed + "(", count1 + 1, count2);
        generateParenthesis(n, ans, seed + ")", count1, count2 + 1);
    }
}
