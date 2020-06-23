package code.code350.question336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 * <p>
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/6/23
 */
public class Solution {
    /**
     * 暴力法
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j == i) {
                    continue;
                }
                String head = words[i];
                String tail = words[j];
                if (head.length() > tail.length()) {
                    if (checkWord(head, tail, tail.length()) && checkWord(head, tail.length(), head.length() - 1)) {
                        ans.add(Arrays.asList(i, j));
                    }
                } else if (head.length() < tail.length()) {
                    if (checkWord(head, tail, head.length()) && checkWord(tail, 0, tail.length() - head.length() - 1)) {
                        ans.add(Arrays.asList(i, j));
                    }
                } else {
                    if (checkWord(head, tail, head.length())) {
                        ans.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        return ans;
    }

    private boolean checkWord(String word, int s, int e) {
        while (s < e) {
            if (word.charAt(s) != word.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    private boolean checkWord(String head, String tail, int length) {
        int i = 0;
        int j = tail.length() - 1;
        while (i < length) {
            if (head.charAt(i) != tail.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
