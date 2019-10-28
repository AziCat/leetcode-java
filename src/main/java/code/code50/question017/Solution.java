package code.code50.question017;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/16
 */
public class Solution {
    /**
     * 利用队列
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (null == digits || digits.isEmpty()) {
            return ans;
        }
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String temp = ans.remove();
                for (int j = 0; j < map[x].length(); j++) {
                    ans.add(temp + map[x].charAt(j));
                }
            }
        }
        return ans;
    }

    public List<String> letterCombinations_(String digits) {
        List<String> list = new ArrayList<>();
        if (null != digits && !"".equals(digits)) {
            for (int i = 0; i < digits.length(); i++) {
                list = buildList(digits.charAt(i), list);
            }
        }
        return list;
    }

    private List<String> buildList(char charAt, List<String> list) {
        List<String> seedList;
        switch (charAt) {
            case '2':
                seedList = Arrays.asList("a", "b", "c");
                break;
            case '3':
                seedList = Arrays.asList("d", "e", "f");
                break;
            case '4':
                seedList = Arrays.asList("g", "h", "i");
                break;
            case '5':
                seedList = Arrays.asList("j", "k", "l");
                break;
            case '6':
                seedList = Arrays.asList("m", "n", "o");
                break;
            case '7':
                seedList = Arrays.asList("p", "q", "r", "s");
                break;
            case '8':
                seedList = Arrays.asList("t", "u", "v");
                break;
            default:
                seedList = Arrays.asList("w", "x", "y", "z");
        }
        if (list.size() == 0) {
            return seedList;
        } else {
            List<String> resultList = new ArrayList<>();
            list.forEach(i -> seedList.forEach(s -> resultList.add(i + s)));
            return resultList;
        }
    }
}
