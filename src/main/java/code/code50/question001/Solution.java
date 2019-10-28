package code.code50.question001;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和<p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/10
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result1 = solution.twoSum1(new int[]{2, 5, 11, 15, 7}, 26);
        int[] result2 = solution.twoSum2(new int[]{2, 5, 11, 15, 7}, 26);
        System.out.println("[" + result1[0] + "," + result1[1] + "]");
        System.out.println("[" + result2[0] + "," + result2[1] + "]");
    }

    /**
     * 暴力遍历
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 利用哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
