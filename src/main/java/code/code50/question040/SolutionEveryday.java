package code.code50.question040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/10
 */
public class SolutionEveryday {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> sub = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, candidates, target);
        return ans;
    }

    private void backtrack(int st, int[] candidates, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for (int i = st; i < candidates.length; i++) {
            if (i > st && candidates[i] == candidates[i - 1]) {
                //过滤重复答案
                continue;
            }
            if (sum + candidates[i] > target) {
                break;
            }
            sum += candidates[i];
            sub.add(candidates[i]);
            backtrack(i + 1, candidates, target);
            sub.remove(sub.size() - 1);
            sum -= candidates[i];
        }
    }
}
