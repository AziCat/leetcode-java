package code.code150.question128;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        //key是当前数字,value是以当前数字作为端点的长度
        Map<Integer, Integer> point = new HashMap<>();
        for (int num : nums) {
            //如果已包含则跳过
            if (!point.containsKey(num)) {
                int nL;
                int left;
                int right;
                //判断是否同时包含num-1与num+1
                if (point.containsKey(num - 1) && point.containsKey(num + 1)) {
                    //更新两侧的端点长度
                    point.put(num, null);
                    nL = point.get(num - 1) + point.get(num + 1) + 1;
                    left = num - point.get(num - 1);
                    right = num + point.get(num + 1);
                } else if (point.containsKey(num - 1)) {
                    //更新左侧
                    nL = point.get(num - 1) + 1;
                    left = num - point.get(num - 1);
                    right = num;
                } else if (point.containsKey(num + 1)) {
                    //更新右侧
                    nL = point.get(num + 1) + 1;
                    left = num;
                    right = num + point.get(num + 1);
                } else {
                    nL = 1;
                    left = num;
                    right = num;
                }
                point.put(left, nL);
                point.put(right, nL);
                max = Math.max(nL, max);
            }
        }
        return max;
    }
}
