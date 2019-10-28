package code.code50.question016;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/16
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Math.abs(-4));
    }

    public int threeSumClosest(int[] nums, int target) {
        int minValue = nums[0] + nums[1] + nums[2];
        //先进行升序排序
        Arrays.sort(nums);
        //遍历数组
        for (int i = 0; i < nums.length - 2; i++) {
            //设置i后面区间的头尾指针
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - minValue)) {
                    minValue = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }

        }
        return minValue;
    }
}
