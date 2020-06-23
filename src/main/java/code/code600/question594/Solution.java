package code.code600.question594;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/5/7
 */
public class Solution {
    /**
     * 排序+双指针
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int start = 0, ans = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] - nums[start] == 1) {
                ans = Math.max(ans, end - start + 1);
            }
            while (nums[end] - nums[start] > 1) {
                start++;
            }
        }
        return ans;
    }

    /**
     * 哈希表记数
     *
     * @param nums
     * @return
     */
    public int findLHS_(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int num : nums) {
            int count = cache.getOrDefault(num, 0);
            cache.put(num, count + 1);
        }
        int ans = 0;
        for (Integer num : cache.keySet()) {
            int maxCount = Math.max(cache.getOrDefault(num + 1, 0), cache.getOrDefault(num - 1, 0));
            if (maxCount != 0) {
                ans = Math.max(ans, cache.get(num) + maxCount);
            }
        }
        return ans;
    }
}
