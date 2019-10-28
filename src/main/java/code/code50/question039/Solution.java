package code.code50.question039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/combination-sum
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/27
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.currentList.add(1);
        s.currentList.add(1);
        s.currentList.add(1);
        s.currentList.add(1);
        s.currentList.remove(s.currentList.size() - 1);
        s.currentList.remove(s.currentList.size() - 1);
        System.out.println(s.currentList.toString());
    }


    private List<List<Integer>> ans = new ArrayList<>();
    private int sum = 0;
    private List<Integer> currentList = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        //currentList.add(candidates[0]);
        //sum += candidates[0];
        backtrack(candidates, target);
        return ans;
    }

    private void backtrack(int[] candidates, int target) {
        for (int candidate : candidates) {
            if (candidate <= target - sum) {
                if (!currentList.isEmpty() && candidate < currentList.get(currentList.size() - 1)) {
                    continue;
                }
                addNumbers(candidate, target);
                //if (currentList.size() != 0) {
                currentList.remove(currentList.size() - 1);
                sum -= candidate;
                //}
            } else {
                break;
            }
        }
    }

    private void addNumbers(int candidate, int target) {
        sum += candidate;
        currentList.add(candidate);
        if (target == sum) {
            List<Integer> subAns = new ArrayList<>(currentList.size());
            subAns.addAll(currentList);
            ans.add(subAns);
        }else {
            backtrack(candidates, target);
        }
    }


}
