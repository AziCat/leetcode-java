package code.code50.question040;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void combinationSum2() {
        int[] c = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> ans = solution.combinationSum2(c, 8);
        String ansStr = "[1, 1, 6]\n" +
                "[1, 2, 5]\n" +
                "[1, 7]\n" +
                "[2, 6]\n";
        StringBuilder sb = new StringBuilder();
        ans.forEach(list -> sb.append(list.toString()).append("\n"));
        Assert.assertEquals(ansStr, sb.toString());
    }

    @Test
    public void combinationSum21() {
        int[] c = {2, 5, 2, 1, 2};
        List<List<Integer>> ans = solution.combinationSum2(c, 5);
        String ansStr = "[1, 2, 2]\n" +
                "[5]\n";
        StringBuilder sb = new StringBuilder();
        ans.forEach(list -> sb.append(list.toString()).append("\n"));
        Assert.assertEquals(ansStr, sb.toString());
    }

    @Test
    public void combinationSum211() {
        int[] c = {1,1};
        List<List<Integer>> ans = solution.combinationSum2(c, 1);
        String ansStr = "[1]\n" ;
        StringBuilder sb = new StringBuilder();
        ans.forEach(list -> sb.append(list.toString()).append("\n"));
        Assert.assertEquals(ansStr, sb.toString());
    }
}