package code.code400.question373;

import java.util.*;

/**
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * <p>
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 * <p>
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/8
 */
public class Solution {
    static class Node {
        int val;
        int n2Index;
        public Node(int val, int n2Index) {
            this.val = val;
            this.n2Index = n2Index;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return ans;
        }
        if (k > nums1.length * nums2.length) {
            k = nums1.length * nums2.length;
        }
        //优先队列+小顶堆
        PriorityQueue<Node> queue = new PriorityQueue<>(nums1.length,
                Comparator.comparingInt(o -> (o.val + nums2[o.n2Index])));
        for (int value : nums1) {
            queue.offer(new Node(value, 0));
        }
        while (k > 0) {
            ans.add(Arrays.asList(queue.peek().val, nums2[queue.peek().n2Index]));
            queue.peek().n2Index++;
            if (queue.peek().n2Index < nums2.length) {
                queue.offer(queue.poll());
            }else {
                queue.poll();
            }
            k--;
        }
        return ans;
    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return ans;
        }
        if (k > nums1.length * nums2.length) {
            k = nums1.length * nums2.length;
        }
        //记录num1某个位置到num2的进度
        int[] position = new int[nums1.length];
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int p = 0;
            for (int j = 0; j < nums1.length; j++) {
                if (position[j] < nums2.length && nums1[j] + nums2[position[j]] < min) {
                    min = nums1[j] + nums2[position[j]];
                    p = j;
                }
            }
            ans.add(Arrays.asList(nums1[p], nums2[position[p]]));
            position[p] += 1;
        }
        return ans;
    }
}
