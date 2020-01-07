package code.code250.question208;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/7
 */
public class Trie {

    private Trie[] children;
    private boolean haveEndpoint = false;
    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.children = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        //insert(word, 0);
        char[] wordArr = word.toCharArray();
        Trie root = this;
        for (int i = 0; i < wordArr.length; i++) {
            Trie child = root.children[wordArr[i] - 'a'];
            if (null == child) {
                child = new Trie();
                root.children[wordArr[i] - 'a'] = child;
            }
            if (i == wordArr.length - 1) {
                child.haveEndpoint = true;
            }
            root = child;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        //return search(word, 0);
        char[] wordArr = word.toCharArray();
        Trie root = this;
        for (int i = 0; i < wordArr.length; i++) {
            Trie child = root.children[wordArr[i] - 'a'];
            if (null == child) {
                return false;
            }
            if (i == wordArr.length - 1) {
                return child.haveEndpoint;
            }
            root = child;
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] wordArr = prefix.toCharArray();
        Trie root = this;
        for (char aWordArr : wordArr) {
            Trie child = root.children[aWordArr - 'a'];
            if (null == child) {
                return false;
            }
            root = child;
        }
        return true;
    }
}
