package code.code50.question041;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * <p>
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/29
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            if (num > nums.length || num < 1) {
                continue;
            }
            arr[num - 1] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public int firstMissingPositive_(int[] nums) {
        int l = nums.length;
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (nums[i] == 1) {
                count++;
            }
            if (nums[i] <= 0 || nums[i] > l) {
                nums[i] = 1;
            }
        }
        if (count == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            nums[a - 1] = -Math.abs(nums[a - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return l + 1;
    }
}
