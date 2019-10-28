package code.code50.question049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/9
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String str : strs) {
            long n = 1L;
            for (int i = 0; i < str.length(); i++) {
                n = n * getNum(str.charAt(i));
            }
            List<String> list = map.get(n);
            if (null == list) {
                list = new ArrayList<>();
                ans.add(list);
                map.put(n, list);
            }
            list.add(str);
        }
        return ans;
    }

    private long getNum(char c) {
        switch (c) {
            case 'a':
                return 3;
            case 'b':
                return 5;
            case 'c':
                return 7;
            case 'd':
                return 11;
            case 'e':
                return 13;
            case 'f':
                return 17;
            case 'g':
                return 19;
            case 'h':
                return 23;
            case 'i':
                return 29;
            case 'j':
                return 31;
            case 'k':
                return 37;
            case 'l':
                return 41;
            case 'm':
                return 43;
            case 'n':
                return 47;
            case 'o':
                return 53;
            case 'p':
                return 59;
            case 'q':
                return 61;
            case 'r':
                return 67;
            case 's':
                return 71;
            case 't':
                return 73;
            case 'u':
                return 79;
            case 'v':
                return 83;
            case 'w':
                return 89;
            case 'x':
                return 97;
            case 'y':
                return 101;
            default:
                return 2;
        }
    }
}
