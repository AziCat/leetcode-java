package code.code50.question034;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/25
 */
public class Solution {
    /**
     * 用2分法咯
     * <p>
     * 如果nums[mid]等于target
     * 判断nums[mid+1]是否大于target，是则right = mid，重新计算mid;否则right--
     * 判断mid-1不小于0且小于target，是则left = mid，重新计算mid；否则left++
     * <p>
     * 如果nums[mid]小于target
     * 把left移到mid+1，重新计算mid
     * <p>
     * 如果nums[mid]大于target
     * 把right移到mid-1，重新计算mid
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }

        int left = 0, right = nums.length - 1, mid = (left + right) / 2;
        while (left <= right && nums[left] != nums[right]) {
            if (nums[mid] == target) {
                if (nums[mid + 1] > target) {
                    right = mid;
                } else {
                    if (nums[right] != target) {
                        right--;
                    }
                }
                if (mid - 1 >= 0 && nums[mid - 1] < target) {
                    left = mid;
                } else {
                    if (nums[left] != target) {
                        left++;
                    }
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        if (left > right || nums[left] != target || nums[right] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }
}
