package code.code450.question416;

import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/9/3
 */
public class Solution {
    /**
     * dfs
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        //倒序dfs，更容易靠近结果
        return dfs(nums, nums.length - 1, sum / 2, sum / 2);
    }

    private boolean dfs(int[] nums, int i, int left, int right) {

        if (left == right && left == 0) {
            return true;
        }
        if (left < 0 || right < 0) {
            return false;
        }
        return dfs(nums, i - 1, left - nums[i], right)
                || dfs(nums, i - 1, left, right - nums[i]);

    }
}
