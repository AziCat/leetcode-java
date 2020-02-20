package code.code300.question268;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void missingNumber() throws Exception {
        Solution solution = new Solution();
        int[] nums = {3, 0, 1};
        Assert.assertEquals(2, solution.missingNumber(nums));
    }

    @Test
    public void missingNumber1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1};
        Assert.assertEquals(0, solution.missingNumber(nums));
    }
}