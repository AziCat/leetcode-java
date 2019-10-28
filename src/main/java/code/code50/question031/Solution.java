package code.code50.question031;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2 (123下一个大的数为132
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 链接：https://leetcode-cn.com/problems/next-permutation
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/24
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int sortIndex = 0;
        boolean acc = false;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    acc = true;
                    sortIndex = i + 1;
                    break;
                }
            }
            if (acc) {
                break;
            }
        }
        Arrays.sort(nums, sortIndex, length);
    }
}
