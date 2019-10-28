package code.code100.question090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/25
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    /**
     * 回溯
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        backtrack(0, nums);
        return ans;
    }

    private void backtrack(int start, int[] nums) {
        for (int i = start; i < nums.length; i++) {
            //排重
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            addNumber(i, nums);
            temp.remove(temp.size() - 1);
        }
    }

    private void addNumber(int index, int[] nums) {
        temp.add(nums[index]);
        if (temp.size() > 0) {
            ans.add(new ArrayList<>(temp));
        }
        backtrack(index + 1, nums);
    }
}
