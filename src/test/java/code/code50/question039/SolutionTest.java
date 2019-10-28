package code.code50.question039;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void combinationSum() {
        int[] c = {2, 3, 5};
        List<List<Integer>> ans = solution.combinationSum(c, 8);
        String ansStr = "[2, 2, 2, 2]\n" +
                "[2, 3, 3]\n" +
                "[3, 5]\n";
        StringBuilder sb = new StringBuilder();
        ans.forEach(list -> sb.append(list.toString()).append("\n"));
        Assert.assertEquals(ansStr, sb.toString());
    }

    @Test
    public void combinationSum1() {
        int[] c = {2, 3, 6, 7};
        List<List<Integer>> ans = solution.combinationSum(c, 7);
        String ansStr = "[2, 2, 3]\n" +
                "[7]\n";
        StringBuilder sb = new StringBuilder();
        ans.forEach(list -> sb.append(list.toString()).append("\n"));
        Assert.assertEquals(ansStr, sb.toString());
    }

    @Test
    public void combinationSum2() {
        int[] c = {2, 3, 6, 7};
        List<List<Integer>> ans = solution.combinationSum(c, 6);
        String ansStr = "[2, 2, 2]\n" +
                "[3, 3]\n" +
                "[6]\n";
        StringBuilder sb = new StringBuilder();
        ans.forEach(list -> sb.append(list.toString()).append("\n"));
        Assert.assertEquals(ansStr, sb.toString());
    }

    @Test
    public void combinationSum3() {
        int[] c = {};
        List<List<Integer>> ans = solution.combinationSum(c, 9);
        String ansStr = "";
        StringBuilder sb = new StringBuilder();
        ans.forEach(list -> sb.append(list.toString()).append("\n"));
        Assert.assertEquals(ansStr, sb.toString());
    }
}