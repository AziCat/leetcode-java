package code.code400.question368;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void largestDivisibleSubset() {
        Solution solution = new Solution();
        List<Integer> ans = solution.largestDivisibleSubset(new int[]{2, 4, 8, 16, 32, 33, 99, 297, 9504});
        Assert.assertEquals("[2, 4, 8, 16, 32, 9504]", ans.toString());
    }

    @Test
    public void largestDivisibleSubset1() {
        Solution solution = new Solution();
        List<Integer> ans = solution.largestDivisibleSubset(new int[]{1, 2, 4, 8, 16});
        Assert.assertEquals("[1, 2, 4, 8, 16]", ans.toString());
    }

    @Test
    public void largestDivisibleSubset2() {
        Solution solution = new Solution();
        List<Integer> ans = solution.largestDivisibleSubset(new int[]{});
        Assert.assertEquals("[]", ans.toString());
    }

    @Test
    public void largestDivisibleSubset21() {
        Solution solution = new Solution();
        List<Integer> ans = solution.largestDivisibleSubset(new int[]{1, 2, 3});
        Assert.assertEquals("[1, 2]", ans.toString());
    }

    @Test
    public void largestDivisibleSubset211() {
        Solution solution = new Solution();
        List<Integer> ans = solution.largestDivisibleSubset(new int[]{1});
        Assert.assertEquals("[1]", ans.toString());
    }

    @Test
    public void largestDivisibleSubset2121() {
        Solution solution = new Solution();
        List<Integer> ans = solution.largestDivisibleSubset(new int[]{22, 33});
        Assert.assertEquals("[22]", ans.toString());
    }
}