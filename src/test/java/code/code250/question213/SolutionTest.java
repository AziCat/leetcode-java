package code.code250.question213;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void rob() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        Assert.assertEquals(4, solution.rob(nums));
    }

    @Test
    public void rob1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        Assert.assertEquals(3, solution.rob(nums));
    }

    @Test
    public void rob12() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1, 4, 2, 4, 6, 8};
        Assert.assertEquals(19, solution.rob(nums));
    }

    @Test
    public void rob33() throws Exception {
        Solution solution = new Solution();
        int[] nums = {2, 1, 4, 1, 8};
        Assert.assertEquals(12, solution.rob(nums));
    }

    @Test
    public void rob21() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 0, 0, 0, 0, 0, 0};
        Assert.assertEquals(1, solution.rob(nums));
    }

    @Test
    public void rob41() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1, 1, 1};
        Assert.assertEquals(3, solution.rob(nums));
    }
}