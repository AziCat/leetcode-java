package code.code50.question033;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/24
 */
public class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int s, int e) {
        if (e - s < 0) {
            return -1;
        } else if (e == s) {
            return nums[s] == target ? 0 : -1;
        }
        int middle = (e + s) / 2;
        if (nums[s] <= nums[middle] && nums[middle + 1] <= nums[e]) {
            //middle刚好是扭曲点
            if (target <= nums[middle] && target >= nums[s]) {
                int ans = Arrays.binarySearch(nums, s, middle + 1, target);
                return ans < 0 ? -1 : ans;
            } else {
                int ans = Arrays.binarySearch(nums, middle + 1, e + 1, target);
                return ans < 0 ? -1 : ans;
            }
        }
        if (nums[s] <= nums[middle]) {
            //说明middle左边没有扭曲点
            if (target <= nums[middle] && target >= nums[s]) {
                int ans = Arrays.binarySearch(nums, s, middle + 1, target);
                return ans < 0 ? -1 : ans;
            } else {
                return search(nums, target, middle + 1, e);
            }
        } else {
            //说明middle右边没有扭曲点
            if (target <= nums[e] && target >= nums[middle + 1]) {
                int ans = Arrays.binarySearch(nums, middle + 1, e + 1, target);
                return ans < 0 ? -1 : ans;
            } else {
                return search(nums, target, s, middle);
            }
        }
    }
}
