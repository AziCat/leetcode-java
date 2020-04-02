package code.code350.question332;

import java.util.*;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 * <p>
 * 说明:
 * <p>
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 * <p>
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 * <p>
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/4/2
 */
public class Solution {
    /**
     * 思路采用https://leetcode-cn.com/problems/reconstruct-itinerary/solution/javadfsjie-fa-by-pwrliang/
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        //构建图
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            PriorityQueue<String> queue = map.get(from);
            if (null == queue) {
                queue = new PriorityQueue<>((s1, s2) -> {
                    for (int i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) != s2.charAt(i)) {
                            return s1.charAt(i) - s2.charAt(i);
                        }
                    }
                    return 0;
                });
            }
            queue.add(to);
            map.put(from, queue);
        }
        List<String> ans = new ArrayList<>();
        dfs(ans, map, "JFK");
        return ans;
    }

    private void dfs(List<String> ans, Map<String, PriorityQueue<String>> map, String from) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            dfs(ans, map, map.get(from).poll());
        }
        ans.add(0, from);
        map.remove(from);
    }
}
