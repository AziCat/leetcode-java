package code.code250.question212;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/9
 */
public class Solution1 {
    class Trie_Node {
        public int endFlagIndex = -1, children_num = 0;
        public Trie_Node parent = null;
        public char value;
        public Trie_Node children[] = new Trie_Node[26];
    }

    class Trie {
        Trie_Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Trie_Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word, int index) {
            int n = word.length();
            Trie_Node p = root;
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                int seq = c - 'a';
                if (p.children[seq] == null) {
                    p.children[seq] = new Trie_Node();
                    p.children[seq].value = c;
                    p.children[seq].parent = p;
                    p.children_num++;

                }
                p = p.children[seq];
            }
            p.endFlagIndex = index;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            int n = word.length();
            Trie_Node p = root;
            int i = 0;
            while (i < n) {
                char c = word.charAt(i);
                int seq = c - 'a';
                if (p.children[seq] == null) {
                    return false;
                }
                p = p.children[seq];
                ++i;
            }
            return p.endFlagIndex != -1;
        }

        public void delete(Trie_Node node) {
            if (node.children_num > 0) {
                node.endFlagIndex = -1;
                return;
            }
            Trie_Node p = node.parent;
            p.children[node.value - 'a'] = null;
            p.children_num--;
            if (p.parent != null && p.endFlagIndex == -1)
                delete(p);
            else
                return;

        }

        public Trie_Node find_same(Trie_Node node, char[][] board, int m, int n, int i, int j, boolean[][] check) {
            Trie_Node res = null;
            char ch = board[i][j];
            int seq = ch - 'a';
            if (node.children[seq] == null) {
                return null;
            }
            check[i][j] = true;
            if (node.children[seq].endFlagIndex != -1)
                res = node.children[seq];
            if (res == null && i > 0 && !check[i - 1][j])
                res = find_same(node.children[seq], board, m, n, i - 1, j, check);
            if (res == null && j < (n - 1) && !check[i][j + 1])
                res = find_same(node.children[seq], board, m, n, i, j + 1, check);
            if (res == null && i < (m - 1) && !check[i + 1][j])
                res = find_same(node.children[seq], board, m, n, i + 1, j, check);
            if (res == null && j > 0 && !check[i][j - 1])
                res = find_same(node.children[seq], board, m, n, i, j - 1, check);
            check[i][j] = false;
            return res;
        }
    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0)
            return res;
        int m = board.length, n = board[0].length;
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++)
            trie.insert(words[i], i);
        boolean[][] check;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check = new boolean[m][n];
                Trie_Node tmp_node = trie.find_same(trie.root, board, m, n, i, j, check);
                if (tmp_node != null) {
                    res.add(words[tmp_node.endFlagIndex]);
                    trie.delete(tmp_node);
                    j--;
                }
            }
        }
        return res;
    }
}
