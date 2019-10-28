package code.code100.question081;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/23
 */
public class Solution {
    /**
     * S:先二分，出现以下3种情况：
     * 1、中分点刚好是旋转点：
     * 判断target在哪一边，然后再使用二分法查找target
     * 2、旋转点在中分点左边，右侧是有序的：
     * 如果target大于右侧最小值，小于右侧最大值，右侧查找target，否则左侧回到开头S
     * 3、旋转点在中分点右边：
     * 如果target大于左侧最小值，小于左侧最大值，左侧查找target，否则右侧回到开头S
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        return search(nums, target, 0, nums.length - 1);
    }

    private boolean search(int[] nums, int target, int s, int e) {
        if (s == e) {
            return nums[s] == target;
        }
        int mid = (s + e) / 2;
        //因为有重复元素，可能存在112111111111111111,或者111111111111112111这种情况
        if (nums[s] == nums[mid] && nums[mid + 1] == nums[e]) {
            return search(nums, target, s, mid) || search(nums, target, mid + 1, e);
        }
        if (nums[s] < nums[mid] && nums[mid + 1] < nums[e]) {
            //中分点刚好是旋转点
            if (target <= nums[mid] && target >= nums[s]) {
                return Arrays.binarySearch(nums, s, mid + 1, target) >= 0;
            } else {
                return Arrays.binarySearch(nums, mid + 1, e + 1, target) >= 0;
            }
        } else if (nums[mid + 1] <= nums[e]) {
            //旋转点在中分点左边，右侧是有序的
            if (target >= nums[mid + 1] && target <= nums[e]) {
                return Arrays.binarySearch(nums, mid + 1, e + 1, target) >= 0;
            } else {
                return search(nums, target, s, mid);
            }
        } else {
            //旋转点在中分点右边
            if (target >= nums[s] && target <= nums[mid]) {
                return Arrays.binarySearch(nums, s, mid + 1, target) >= 0;
            } else {
                return search(nums, target, mid + 1, e);
            }
        }
    }
}
