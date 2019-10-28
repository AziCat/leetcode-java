package code.code50.question030;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",0
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/19
 */
public class Solution {
    public static void main(String[] args) {
        String[] words = {"word", "good", "best", "word"};
        List<String> list = Arrays.asList("word", "good", "best", "word");
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        System.out.println(list2.contains(1));
        System.out.println(list2.contains(2));
        System.out.println(list2.contains(8));
        System.out.println(Arrays.binarySearch(words, "word"));
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "");
        map.put(2, "");
        map.put(3, "");
        System.out.println(map.size());
    }

    /**
     * 超时
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0) {
            return ans;
        }
        int wordLength = words[0].length();
        Map<String, Integer> wordsMap = new HashMap<>(16);
        Map<String, Integer> currentWordsMap = new HashMap<>(16);
        for (String word : words) {
            Integer count = wordsMap.get(word);
            if (null == count) {
                count = 1;
                wordsMap.put(word, count);
            } else {
                wordsMap.put(word, count + 1);
            }
        }
        for (int i = 0; i <= s.length() - words.length * wordLength; i++) {
            boolean acc = true;
            for (int j = i; j < i + wordLength * words.length; j += wordLength) {
                String str = s.substring(j, j + wordLength);
                Integer currentCount = currentWordsMap.get(str);
                if (currentCount == null) {
                    currentCount = 0;
                }
                currentCount++;
                if (wordsMap.get(str) == null || currentCount > wordsMap.get(str)) {
                    acc = false;
                    currentWordsMap.clear();
                    break;
                } else {
                    currentWordsMap.put(str, currentCount);
                }
            }
            if (acc) {
                ans.add(i);
                currentWordsMap.clear();
            }

        }
        return ans;
    }
}
