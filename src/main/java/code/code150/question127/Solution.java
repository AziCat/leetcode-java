package code.code150.question127;

import javafx.util.Pair;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 双端bfs优化
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (null == wordList || wordList.isEmpty()) {
            return 0;
        }
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        //可用单词字典
        HashSet<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) {
            return 0;
        }
        begin.add(beginWord);
        end.add(endWord);
        //如果存在转换结果，最短距离从2开始
        return bfs(begin, end, dic, 2);
    }

    private int bfs(HashSet<String> oneSide, HashSet<String> otherSide, HashSet<String> dic, int level) {
        if (oneSide.size() == 0) {
            //其中一侧断裂，无法完成转换
            return 0;
        }
        if (oneSide.size() > otherSide.size()) {
            //从小的那边进行查找效率比较高
            return bfs(otherSide, oneSide, dic, level);
        }
        //使用过的单词从字典中移除
        dic.removeAll(oneSide);
        HashSet<String> nextSide = new HashSet<>();
        for (String s : oneSide) {
            char[] sChars = s.toCharArray();
            for (int i = 0; i < sChars.length; i++) {
                char temp = sChars[i];
                //替换单个字符
                for (char j = 'a'; j < 'z'; j++) {
                    if(j==temp){
                        continue;
                    }
                    sChars[i] = j;
                    String newStr = new String(sChars);
                    if (dic.contains(newStr)) {
                        //如果字典包含此字符串，说明可以转换
                        if (otherSide.contains(newStr)) {
                            //另一侧已转换到此字符串，直接返回当前等级
                            return level;
                        } else {
                            //作为下层bfs的一端
                            nextSide.add(newStr);
                        }
                    }
                }
                //还原字符串
                sChars[i] = temp;
            }
        }
        //下层bfs
        return bfs(nextSide, otherSide, dic, level + 1);
    }


    /**
     * 双端bfs
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength_(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int wordLength = beginWord.length();
        //预处理
        Map<String, List<String>> combineMap = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
                List<String> combineList = combineMap.getOrDefault(newWord, new ArrayList<>());
                combineList.add(word);
                combineMap.put(newWord, combineList);
            }
        });
        //头队列
        LinkedList<Pair<String, Integer>> beginQueue = new LinkedList<>();
        //尾队列
        LinkedList<Pair<String, Integer>> endQueue = new LinkedList<>();

        //用于记录某单词是否已被访问
        Map<String, Integer> beginVisited = new HashMap<>();
        Map<String, Integer> endVisited = new HashMap<>();

        //开始词与结束词层级都为1
        beginQueue.addLast(new Pair<>(beginWord, 1));
        endQueue.addLast(new Pair<>(endWord, 1));

        //设置成已访问
        beginVisited.put(beginWord, 1);
        endVisited.put(endWord, 1);

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            //从头开始
            int start = helper(beginQueue, wordLength, combineMap, beginVisited, endVisited);
            if (start > 0) {
                return start;
            }
            //从尾开始
            int end = helper(endQueue, wordLength, combineMap, endVisited, beginVisited);
            if (end > 0) {
                return end;
            }
        }
        return 0;
    }

    private int helper(LinkedList<Pair<String, Integer>> currentQueue,
                       int wordLength,
                       Map<String, List<String>> combineMap,
                       Map<String, Integer> currentVisited,
                       Map<String, Integer> otherVisited) {
        Pair<String, Integer> head = currentQueue.pollFirst();
        //当前单词
        String word = head.getKey();
        //层级
        Integer level = head.getValue();
        for (int i = 0; i < wordLength; i++) {
            //获取当前单词可以转换的单词列表
            String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
            List<String> combineList = combineMap.getOrDefault(newWord, new ArrayList<>());
            for (String s : combineList) {
                if (otherVisited.containsKey(s)) {
                    //如果这个单词在另一边已经访问到，两边相遇可以直接返回
                    return level + otherVisited.get(s);
                }
                if (!currentVisited.containsKey(s)) {
                    //如果当前没访问过这个单词，添加到已访问字典，并添加到队列中
                    currentVisited.put(s, level + 1);
                    currentQueue.addLast(new Pair<>(s, level + 1));
                }
            }
        }
        return -1;
    }
}
