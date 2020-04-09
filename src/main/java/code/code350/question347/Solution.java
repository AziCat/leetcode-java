package code.code350.question347;

import javafx.util.Pair;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/4/9
 */
public class Solution {
    /**
     * 使用优先队列，小根堆
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        //统计各数字出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer size = map.get(num);
            if (null == size) {
                size = 0;
            }
            map.put(num, size + 1);
        }
        //优先队列，大小为k
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        map.forEach((num, size) -> {
            if (queue.size() < k) {
                queue.add(new Pair<>(num, size));
            } else {
                if (size > queue.peek().getValue()) {
                    queue.poll();
                    queue.add(new Pair<>(num, size));
                }
            }
        });
        List<Integer> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll().getKey());
        }
        return ans;
    }
}
