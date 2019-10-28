package code.code50.question040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/29
 */
public class Solution {
    private int[] candidates;
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> currentList = new ArrayList<>();
    private int sum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        backtrack(target, 0);
        return ans;
    }

    private void backtrack(int target, int startIndex) {
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]){
                //排重
                continue;
            }
            int candidate = candidates[i];
            if (candidate > target - sum) {
                break;
            } else {
                if (!currentList.isEmpty() && candidate < currentList.get(currentList.size() - 1)) {
                    break;
                }
                addNumber(i, candidate, target);
                removeNumber(i, candidate);
            }
        }
    }

    private void removeNumber(int i, int candidate) {
        sum -= candidate;
        currentList.remove(currentList.size() - 1);
    }

    private void addNumber(int i, int candidate, int target) {
        sum += candidate;
        currentList.add(candidate);
        if (sum == target) {
            List<Integer> subAns = new ArrayList<>(currentList.size());
            subAns.addAll(currentList);
            ans.add(subAns);
        } else {
            backtrack(target, i + 1);
        }
    }


}
