package code.code250.question211;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 * <p>
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/8
 */
public class WordDictionary {

    /**
     * 长度字典哈希表
     */
    private Map<Integer, HashSet<String>> dic;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.dic = new HashMap<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        HashSet<String> hashSet = dic.getOrDefault(word.length(), new HashSet<>());
        hashSet.add(word);
        dic.put(word.length(), hashSet);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        int length = word.length();
        HashSet<String> hashSet = dic.get(length);
        if (null == hashSet) {
            return false;
        }
        if (hashSet.contains(word)) {
            return true;
        } else {
            for (String s : hashSet) {
                if (compare(s, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean compare(String s, String word) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != word.charAt(i) && word.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }
}
