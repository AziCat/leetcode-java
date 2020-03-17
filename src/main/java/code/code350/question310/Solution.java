package code.code350.question310;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 * <p>
 * 格式
 * <p>
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 * <p>
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/3/3
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1 && edges.length == 0) {
            //这是个什么奇怪的测试用例= =
            ans.add(0);
            return ans;
        }

        //计算每个节点的连线，连线数为1的是子节点
        HashSet<Integer>[] cache = new HashSet[n];
        int counter = 0;
        for (int[] edge : edges) {
            if (cache[edge[0]] == null) {
                cache[edge[0]] = new HashSet<>();
                counter++;
            }
            if (cache[edge[1]] == null) {
                cache[edge[1]] = new HashSet<>();
                counter++;
            }
            cache[edge[0]].add(edge[1]);
            cache[edge[1]].add(edge[0]);
        }
        //从子节点开始删除
        while (counter > 2) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < cache.length; i++) {
                if (null != cache[i] && cache[i].size() == 1) {
                    temp.add(i);
                }
            }
            for (Integer i : temp) {
                int node = cache[i].iterator().next();
                cache[i] = null;
                counter--;
                cache[node].remove(i);
                if (cache[node].size() == 0) {
                    counter--;
                }
            }
        }
        for (int i = 0; i < cache.length; i++) {
            if (null != cache[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
