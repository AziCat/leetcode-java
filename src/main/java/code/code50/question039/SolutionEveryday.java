package code.code50.question039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/9
 */
public class SolutionEveryday {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> sub = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (sum + candidates[i] > target) {
                break;
            }
            sum += candidates[i];
            sub.add(candidates[i]);
            backtrack(i, candidates, target);
            sub.remove(sub.size() - 1);
            sum -= candidates[i];
        }
    }
}
