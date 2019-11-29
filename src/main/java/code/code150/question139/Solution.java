package code.code150.question139;


import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/11/28
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("123".substring(2, 3));
    }

    private HashSet<String> dict;
    //字典中最长的单词长度
    private int maxLen = 0;

    /**
     * 动态规则
     * dp[i]表示s从0到i能否被切割
     * 1ms
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>();
        for (String dictStr : wordDict) {
            dict.add(dictStr);
            maxLen = Math.max(maxLen, dictStr.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 && j >= i - maxLen; j--) {
                //以j为分割点，满足以下条件时dp[i]为true，因为字典单词有长度，所以分割点j在字典单词最大长度内找即可
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 双端bfs
     * 4ms
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak__(String s, List<String> wordDict) {
        dict = new HashSet<>();
        for (String dictStr : wordDict) {
            dict.add(dictStr);
            maxLen = Math.max(maxLen, dictStr.length());
        }
        //记录已访问的单词
        HashSet<String> visitedStart = new HashSet<>();
        HashSet<String> visitedEnd = new HashSet<>();

        //队列
        LinkedList<Pair<String, String>> queueStart = new LinkedList<>();
        LinkedList<Pair<String, String>> queueEnd = new LinkedList<>();

        Pair<String, String> start = new Pair<>("", s);
        queueStart.addLast(start);
        visitedStart.add("");

        Pair<String, String> end = new Pair<>("", s);
        queueEnd.addLast(end);
        visitedEnd.add("");

        return bfs(queueStart, queueEnd, visitedStart, visitedEnd, true);
    }

    private boolean bfs(LinkedList<Pair<String, String>> queue, LinkedList<Pair<String, String>> queueOther, HashSet<String> visited, HashSet<String> visitedOther, boolean order) {
        if (queue.isEmpty()) {
            //出现断裂
            return false;
        }
        if (queueOther.size() < queue.size()) {
            //从队列内容小的一端开始，减少计算次数
            return bfs(queueOther, queue, visitedOther, visited, !order);
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Pair<String, String> item = queue.pollFirst();
            String pre = item.getKey();
            String str = item.getValue();
            if (order) {
                //顺序
                for (int j = 0; j < str.length() && j < maxLen; j++) {
                    String temp = str.substring(0, j + 1);
                    if (dict.contains(temp)) {
                        String otherStr = str.substring(j + 1, str.length());
                        //如果包含在字典内
                        String visitedStr = pre + temp;
                        if (visitedOther.contains(otherStr)) {
                            return true;
                        }
                        if (!visited.contains(visitedStr)) {
                            visited.remove(pre);
                            visited.add(visitedStr);
                            queue.addLast(new Pair<>(visitedStr, otherStr));
                        }
                    }
                }
            } else {
                //倒序
                for (int j = str.length(); j > 0 && j > str.length() - maxLen; j--) {
                    String temp = str.substring(j - 1, str.length());
                    if (dict.contains(temp)) {
                        String otherStr = str.substring(0, j - 1);
                        //如果包含在字典内
                        String visitedStr = temp + pre;
                        if (visitedOther.contains(otherStr)) {
                            return true;
                        }
                        if (!visited.contains(visitedStr)) {
                            visited.remove(pre);
                            visited.add(visitedStr);
                            queue.addLast(new Pair<>(visitedStr, otherStr));
                        }
                    }
                }
            }
        }
        return bfs(queue, queueOther, visited, visitedOther, order);
    }

    /**
     * 超出时间限制
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_(String s, List<String> wordDict) {
        return wordBreak(s, 0, wordDict);
    }

    private boolean wordBreak(String s, int st, List<String> wordDict) {
        for (int i = st + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(st, i))) {
                if (i == s.length()) {
                    return true;
                }
                if (wordBreak(s, i, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
}
