package code.code100.question053;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/10
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int l = 0, r = 0;
        int count = 0;
        while (l < nums.length && r < nums.length) {
            if (l == r) {
                count = nums[l];
                ans = Math.max(ans, count);
                r++;
            } else {
                count += nums[r];
                //如果加了nums[r]比nums[r]更小，重置指针
                if (count < nums[r]) {
                    l = r;
                    count = 0;
                } else {
                    ans = Math.max(ans, count);
                    r++;
                }
            }
        }
        return ans;
    }
}
