package code.code150.question131;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private List<List<String>> ans = new ArrayList<>();
    private List<String> temp = new ArrayList<>();
    private int length;
    private String s;

    /**
     * 递归回溯
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        this.length = s.length();
        this.s = s;
        if (length != 0) {
            backtrack(0);
        }
        return ans;
    }

    private void backtrack(int st) {
        for (int i = length - 1; i >= st; i--) {
            if (isPalindromes(st, i)) {
                //如果是回文词，添加到临时列表中
                putList(st, i + 1);
                //移除最后一个回文词
                temp.remove(temp.size() - 1);
            }
        }
    }

    private void putList(int st, int en) {
        temp.add(s.substring(st, en));
        if (en == length) {
            //如果到了当前字符最后的位置，添加答案
            List<String> subAns = new ArrayList<>(temp);
            ans.add(subAns);
        } else {
            backtrack(en);
        }
    }

    private boolean isPalindromes(int st, int en) {
        if (st == en) {
            return true;
        }
        while (st < en) {
            if (s.charAt(st) != s.charAt(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}
