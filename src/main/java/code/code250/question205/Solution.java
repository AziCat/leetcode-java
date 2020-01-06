package code.code250.question205;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/6
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] s2t = new char[127];
        char[] t2s = new char[127];
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s2t[S[i]] != '\0' || t2s[T[i]] != '\0') {
                if (s2t[S[i]] != T[i]) {
                    return false;
                }
            } else {
                s2t[S[i]] = T[i];
                t2s[T[i]] = S[i];
            }
        }

        return true;
    }
}
