package code.code500.question480;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yjh
 * @version 1.0
 * @since 2021/2/3 15:22
 */
public class Solution {
    /**
     * 建立大顶堆和小顶堆，维持两个顶堆的大小不相差超过1，中位数则位于两个顶堆的堆顶之和的平均、或者位于尺寸较大的堆顶
     *
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Long> maxTop = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
        PriorityQueue<Long> minTop = new PriorityQueue<>();
        int i = 0;
        for (int num : nums) {
            if ((!maxTop.isEmpty() && num > maxTop.peek())
                    || (!minTop.isEmpty() && num >= minTop.peek())) {
                minTop.offer((long) num);
            } else {
                maxTop.offer((long) num);
            }
            //平衡两个顶堆
            if (Math.abs(maxTop.size() - minTop.size()) > 1) {
                reBalance(maxTop, minTop);
            }
            if (maxTop.size() + minTop.size() == k) {
                result[i] = k % 2 == 0 ? (maxTop.peek() + minTop.peek()) / 2.0 :
                        maxTop.size() > minTop.size() ? maxTop.peek() : minTop.peek();
                if (!maxTop.isEmpty() && nums[i] > maxTop.peek()) {
                    minTop.remove((long) nums[i]);
                } else {
                    maxTop.remove((long) nums[i]);
                }
                i++;
            }
        }
        return result;
    }

    private void reBalance(PriorityQueue<Long> maxTop, PriorityQueue<Long> minTop) {
        if (maxTop.size() > minTop.size()) {
            minTop.offer(maxTop.poll());
        } else {
            maxTop.offer(minTop.poll());
        }
        if (Math.abs(maxTop.size() - minTop.size()) > 1) {
            reBalance(maxTop, minTop);
        }
    }
}
