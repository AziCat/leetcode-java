package code.code50.question047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/8
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>(3);
    private int[] used;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new int[nums.length];
        backtrack();
        return ans;
    }

    private void backtrack() {
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == -1) {
                    continue;
                }
                addNumber(i);
                removeNumber(i);
            }
        }
    }

    private void removeNumber(int i) {
        used[i] = 0;
        temp.remove(temp.size() - 1);
    }

    private void addNumber(int i) {
        used[i] = -1;
        temp.add(nums[i]);
        if (temp.size() == nums.length) {
            List<Integer> list = new ArrayList<>(temp);
            ans.add(list);
        } else {
            backtrack();
        }
    }
}
