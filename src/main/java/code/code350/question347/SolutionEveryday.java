package code.code350.question347;

import javafx.util.Pair;

import java.util.*;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/7
 */
public class SolutionEveryday {
    public int[] topKFrequent(int[] nums, int k) {
        //统计出现次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }
        //优先队列作为小顶堆，出现次数小的在堆顶
        PriorityQueue<Pair<Integer, Integer>> stack = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        countMap.forEach((num, count) -> {
            if (stack.size() < k) {
                stack.offer(new Pair<>(num, count));
            } else {
                //比较堆顶大小
                if (stack.peek().getValue() < count) {
                    stack.poll();
                    stack.offer(new Pair<>(num, count));
                }
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = stack.poll().getKey();
        }
        return ans;
    }
}
