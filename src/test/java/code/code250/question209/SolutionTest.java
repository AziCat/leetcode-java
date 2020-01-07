package code.code250.question209;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void minSubArrayLen() throws Exception {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
        Assert.assertEquals(2, solution.minSubArrayLen(7, nums));
    }
    @Test
    public void minSubArrayLen1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {};
        Assert.assertEquals(0, solution.minSubArrayLen(7, nums));
    }
    @Test
    public void minSubArrayLen11() throws Exception {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
        Assert.assertEquals(0, solution.minSubArrayLen(999, nums));
    }

}