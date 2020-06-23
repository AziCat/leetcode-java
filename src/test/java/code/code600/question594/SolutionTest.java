package code.code600.question594;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findLHS() {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.findLHS(nums));
    }

    @Test
    public void findLHS1() {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7, 8, 8, 8, 8, 8, 7};
        Solution solution = new Solution();
        Assert.assertEquals(7, solution.findLHS(nums));
    }

    @Test
    public void findLHS2() {
        int[] nums = {1, 1};
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.findLHS(nums));
    }

    @Test
    public void findLHS3() {
        int[] nums = {1, 2, 2, 5, 5, 5, 6, 6};
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.findLHS(nums));
    }
}