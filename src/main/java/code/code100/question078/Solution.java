package code.code100.question078;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/subsets
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/22
 */
public class Solution {
    private int[] nums;
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        ans.add(temp);
        backtrack(0);
        return ans;
    }

    private void backtrack(int index) {
        for (int i = index; i < nums.length; i++) {
            put(i);
            temp.remove(temp.size() - 1);
        }
    }

    private void put(int index) {
        temp.add(nums[index]);
        ans.add(new ArrayList<>(temp));
        backtrack(index + 1);
    }
}
