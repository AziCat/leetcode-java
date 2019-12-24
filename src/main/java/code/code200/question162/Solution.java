package code.code200.question162;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 * <p>
 * 你的解法应该是 O(logN) 时间复杂度的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/24
 */
public class Solution {
    /**
     * 有时间复杂度要求，使用二分法
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int s, int e) {
        if (e < s) {
            return s;
        }
        if (e > nums.length) {
            return e;
        }
        if (s == e ) {
            return s;
        }
        int mid = (s + e) / 2;
        int left = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1];
        int right = mid + 1 > nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];
        if (nums[mid] > left && nums[mid] > right) {
            return mid;
        } else {
            return left > right ? findPeakElement(nums, s, mid - 1) : findPeakElement(nums, mid + 1, e);
        }
    }
}
