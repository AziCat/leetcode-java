package code.interview.question51;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void reversePairs() throws Exception {
        Solution solution = new Solution();
        int[] nums = {7, 5, 6, 4};
        Assert.assertEquals(5, solution.reversePairs(nums));

    }

    @Test
    public void reversePairs1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {8, 7, 5, 6, 4};
        Assert.assertEquals(9, solution.reversePairs(nums));

    }

    @Test
    public void reversePairs111() throws Exception {
        Solution solution = new Solution();
        int[] nums = {5, 1, 2, 3, 4};
        Assert.assertEquals(4, solution.reversePairs(nums));

    }

    @Test
    public void reversePairs21() throws Exception {
        Solution solution = new Solution();
        int[] nums = {4};
        Assert.assertEquals(0, solution.reversePairs(nums));

    }

    @Test
    public void reversePairs11() throws Exception {
        Solution solution = new Solution();
        int[] nums = {};
        Assert.assertEquals(0, solution.reversePairs(nums));

    }
}