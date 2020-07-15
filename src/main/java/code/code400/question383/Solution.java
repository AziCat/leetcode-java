package code.code400.question383;

import java.util.Random;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/15
 */
public class Solution {
    private final int[] cache = new int[26];
    private int p = 0;

    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!check(c, magazine)) {
                return false;
            }

        }
        return true;
    }

    private boolean check(char target, String magazine) {
        if (cache[target - 'a'] > 0) {
            cache[target - 'a'] -= 1;
            return true;
        }
        while (p < magazine.length()) {
            char c = magazine.charAt(p);
            p++;
            if (c != target) {
                cache[c - 'a'] += 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
