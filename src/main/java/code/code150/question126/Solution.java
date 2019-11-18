package code.code150.question126;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 从127题那里修改一下，双端bfs
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (null == wordList || wordList.isEmpty()) {
            return Collections.emptyList();
        }
        HashMap<String, List<List<String>>> begin = new HashMap<>();
        HashMap<String, List<List<String>>> end = new HashMap<>();
        //可用单词字典
        HashSet<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) {
            return Collections.emptyList();
        }
        List<List<String>> level = new ArrayList<>();
        List<List<String>> level2 = new ArrayList<>();
        level.add(new ArrayList<>());
        level2.add(new ArrayList<>());
        begin.put(beginWord, level);
        end.put(endWord, level2);
        return bfs(begin, end, dic, true);
    }

    private List<List<String>> bfs(HashMap<String, List<List<String>>> oneSide,
                                   HashMap<String, List<List<String>>> otherSide, HashSet<String> dic, boolean isOrder) {
        if (oneSide.size() == 0) {
            //其中一侧断裂，无法完成转换
            return Collections.emptyList();
        }
        if (oneSide.size() > otherSide.size()) {
            //从小的那边进行查找效率比较高，从另一端开始，顺序反转
            return bfs(otherSide, oneSide, dic, !isOrder);
        }
        HashMap<String, List<List<String>>> nextMap = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        //使用过的单词从字典中移除
        dic.removeAll(oneSide.keySet());
        for (String s : oneSide.keySet()) {
            char[] sChars = s.toCharArray();
            List<List<String>> nextList = new ArrayList<>();
            for (List<String> strings : oneSide.get(s)) {
                List<String> temp = new ArrayList<>(strings);
                if (isOrder) {
                    temp.add(s);
                } else {
                    temp.add(0, s);
                }
                nextList.add(temp);
            }
            for (int i = 0; i < sChars.length; i++) {
                char temp = sChars[i];
                //替换单个字符
                for (char j = 'a'; j < 'z'; j++) {
                    if (j == temp) {
                        continue;
                    }
                    sChars[i] = j;
                    String newStr = new String(sChars);
                    if (dic.contains(newStr)) {
                        //如果字典包含此字符串，说明可以转换
                        if (otherSide.keySet().contains(newStr)) {

                            //另一侧已转换到此字符串，构建返回结果
                            List<List<String>> otherList = otherSide.get(newStr);
                            for (List<String> subOtherList : otherList) {
                                for (List<String> subNextList : nextList) {
                                    List<String> subAns;
                                    if (isOrder) {
                                        subAns = new ArrayList<>(subNextList);
                                        subAns.add(newStr);
                                        subAns.addAll(subOtherList);
                                    } else {
                                        subAns = new ArrayList<>(subOtherList);
                                        subAns.add(newStr);
                                        subAns.addAll(subNextList);
                                    }
                                    ans.add(subAns);
                                }
                            }
                        } else if (ans.isEmpty()) {
                            //作为下层bfs的一端
                            List<List<String>> exitList = nextMap.getOrDefault(newStr, new ArrayList<>());
                            exitList.addAll(nextList);
                            nextMap.put(newStr, exitList);
                        }
                    }
                }
                //还原字符串
                sChars[i] = temp;
            }
        }
        if (!ans.isEmpty()) {
            return ans;
        }
        //下层bfs
        return bfs(nextMap, otherSide, dic, isOrder);
    }
}
