package code.code350.question324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/3/25
 */
public class Solution {
    /**
     * 思路一：先排序，然后从中间开始把大的数往两个小的数中间插入
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        Arrays.sort(nums);
        int length = nums.length;
        int[] sortedNums = new int[length];
        int index = 0;
        int window = length / 2;
        int mid = (length - 1) / 2;
        for (int i = length - 1; i > mid; i--) {
            sortedNums[index++] = nums[i - window];
            sortedNums[index++] = nums[i];
        }
        if (length % 2 == 1) {
            sortedNums[index] = nums[0];
        }

        System.arraycopy(sortedNums, 0, nums, 0, length);
    }


}
