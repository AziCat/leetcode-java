package code.code150.question140;

import javafx.util.Pair;

import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/11/28
 */
public class Solution {
    private List<String> ans = new ArrayList<>();
    private List<String> wordDict;


    /**
     * 动态规则 dp[i]= dp[j1].add(subStr1) + dp[j2].add(subStr2) +....
     * 3ms
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        //最长的字典长度，遍历时不超过这个长度
        int maxLen = 0;
        List<String>[] dp = new List[s.length() + 1];
        for (String str : wordDict) {
            maxLen = Math.max(maxLen, str.length());
            dict.add(str);
        }
        boolean[] bool = new boolean[s.length() + 1];
        bool[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 && j >= i - maxLen; j--) {
                //以j为分割点，满足以下条件时dp[i]为true，因为字典单词有长度，所以分割点j在字典单词最大长度内找即可
                if (bool[j] && dict.contains(s.substring(j, i))) {
                    bool[i] = true;
                    break;
                }
            }
        }
        dp[0] = new ArrayList<>();
        dp[s.length()] = new ArrayList<>();
        if (bool[s.length()]) {
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i - 1; j >= 0 && j >= i - maxLen; j--) {
                    String subStr = s.substring(j, i);
                    if (dp[j] != null && dict.contains(subStr)) {
                        if (null == dp[i]) {
                            dp[i] = new ArrayList<>();
                        }
                        if (dp[j].isEmpty()) {
                            dp[i].add(subStr);
                        } else {
                            for (String str : dp[j]) {
                                dp[i].add("".equals(str) ? subStr : (str + " " + subStr));
                            }
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 7ms
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak_(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        LinkedList<Pair<String, String>> startQueue = new LinkedList<>();
        startQueue.addLast(new Pair<>("", s));
        HashSet<String> dict = new HashSet<>();
        //最长的字典长度，遍历时不超过这个长度
        int maxLen = 0;
        for (String str : wordDict) {
            maxLen = Math.max(maxLen, str.length());
            dict.add(str);
        }
        boolean[] bool = new boolean[s.length() + 1];
        bool[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 && j >= i - maxLen; j--) {
                //以j为分割点，满足以下条件时dp[i]为true，因为字典单词有长度，所以分割点j在字典单词最大长度内找即可
                if (bool[j] && dict.contains(s.substring(j, i))) {
                    bool[i] = true;
                    break;
                }
            }
        }
        if (bool[s.length()]) {
            bfs(startQueue);
        }
        return ans;
    }

    private void bfs(LinkedList<Pair<String, String>> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Pair<String, String> item = queue.pollFirst();
            String pre = item.getKey();
            String str = item.getValue();
            for (String word : wordDict) {
                if (str.startsWith(word)) {
                    String otherStr = str.substring(word.length(), str.length());
                    String visitedStr = pre.equals("") ? word : pre + " " + word;
                    if ("".equals(otherStr)) {
                        ans.add(visitedStr);
                        //}
                    } else {
                        queue.addLast(new Pair<>(visitedStr, otherStr));
                    }
                }
            }

        }
        bfs(queue);
    }
}
