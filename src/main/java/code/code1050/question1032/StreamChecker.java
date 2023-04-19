package code.code1050.question1032;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
 * <p>
 * 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到 "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/stream-of-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/3/24
 */
public class StreamChecker {
    private final Node root;
    private final List<Character> letterList;

    /**
     * 1 <= words.length <= 2000
     * 1 <= words[i].length <= 200
     * words[i] 由小写英文字母组成
     *
     * @param words
     */
    public StreamChecker(String[] words) {
        this.root = new Node();
        this.letterList = new ArrayList<>();
        for (String word : words) {
            this.root.build(word, word.length() - 1);
        }
    }

    public boolean query(char letter) {
        letterList.add(letter);
        return root.search(letterList, letterList.size() - 1);
    }

    public static class Node {
        public Node[] child = new Node[26];
        public boolean isEnd = false;

        public void build(String word, int index) {
            if (index < 0) {
                this.isEnd = true;
            } else {
                char c = word.charAt(index);
                Node childNode = child[c - 'a'];
                if (childNode == null) {
                    childNode = new Node();
                }
                childNode.build(word, index - 1);
                child[c - 'a'] = childNode;
            }
        }

        public boolean search(List<Character> letterList, int index) {
            if (index < 0) {
                return false;
            }else {
                char c = letterList.get(index);
                Node childNode = child[c - 'a'];
                if (childNode == null) {
                    return false;
                }
                if (childNode.isEnd) {
                    return true;
                }else {
                    return childNode.search(letterList, index - 1);
                }
            }
        }
    }
}
