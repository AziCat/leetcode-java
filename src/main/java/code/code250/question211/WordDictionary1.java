package code.code250.question211;

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
public class WordDictionary1 {

    /**
     * 前缀树
     */
    class Trie {
        private Trie[] children;
        private boolean end;

        Trie() {
            this.children = new Trie[26];
        }

        void insert(String word) {
            char[] arr = word.toCharArray();
            Trie root = this;
            for (char c : arr) {
                Trie child = root.children[c - 'a'];
                if (null == child) {
                    child = new Trie();
                    root.children[c - 'a'] = child;
                }
                root = child;
            }
            root.end = true;
        }

        boolean search(String key, int i) {
            if (i == key.length()) {
                return this.end;
            }
            if ('.' == key.charAt(i)) {
                for (Trie node : this.children) {
                    if (null != node) {
                        if (node.search(key, i + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                Trie node = this.children[key.charAt(i) - 'a'];
                return null != node && node.search(key, i + 1);
            }
        }
    }

    private Trie root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary1() {
        this.root = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        root.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return root.search(word, 0);
    }
}
