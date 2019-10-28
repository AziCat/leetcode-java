package code.code50.question018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/4sum
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/16
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        //循环最左侧的两个数，右侧用双指针
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > target && target > 0) {
                return ans;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j == i + 1 || nums[j] != nums[j - 1]) {
                    int L = j + 1, R = nums.length - 1, sum = target - nums[i] - nums[j];
                    while (L < R) {
                        if (sum == nums[L] + nums[R]) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                            while (L < R && nums[L] == nums[L + 1]) {
                                L++;
                            }
                            L++;
                            while (L < R && nums[R - 1] == nums[R]) {
                                R--;
                            }
                            R--;
                        } else if (sum > nums[L] + nums[R]) {
                            L++;
                        } else {
                            R--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
