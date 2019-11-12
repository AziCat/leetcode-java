package code.code150.question118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        List<Integer> sub = new ArrayList<>();

        return ans;
    }

    public List<List<Integer>> generate_(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        if (numRows > 0) {
            helper(ans, 0, numRows);
        }
        return ans;
    }

    private void helper(List<List<Integer>> ans, int i, int numRows) {
        if (i < numRows) {
            if (i == 0) {
                ans.add(Collections.singletonList(1));
            } else {
                List<Integer> sub = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        sub.add(1);
                    } else {
                        sub.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                    }
                }
                ans.add(sub);
            }
            helper(ans, i + 1, numRows);
        }
    }
}
