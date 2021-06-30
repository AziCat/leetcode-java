package code.code2000.question1985;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/6/22
 */
public class Solution {
    private final Map<String, List<String>> dict = new HashMap<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> ans = dfs(chars);
        return ans.toArray(new String[]{});
    }

    private List<String> dfs(char[] chars) {
        String s = new String(chars).trim();
        if (chars.length == 0 || s.length() == 0) {
            return Collections.singletonList("");
        }
        if (dict.containsKey(s)) {
            return dict.get(s);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ' || (i != 0 && chars[i] == chars[i - 1])) {
                continue;
            }
            chars[i] = ' ';
            //递归
            List<String> subAns = dfs(chars);
            //回溯
            chars[i] = c;
            subAns.forEach(str -> ans.add(c + str));
        }
        dict.put(s, ans);
        return ans;
    }

}

