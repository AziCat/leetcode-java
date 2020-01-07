package code.code250.question209;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/7
 */
public class Solution {
    /**
     * 双指针
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, ans = Integer.MAX_VALUE, sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            if (sum >= s) {
                while (sum - nums[left] >= s) {
                    sum -= nums[left];
                    left++;
                }
                ans = Math.min(ans, (right - left + 1));
            }
            right++;

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
