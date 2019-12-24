package code.code200.question162;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findPeakElement() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        Assert.assertEquals(5, solution.findPeakElement(nums));
    }

    @Test
    public void findPeakElement1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 1};
        Assert.assertEquals(1, solution.findPeakElement(nums));
    }

    @Test
    public void findPeakElement2() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2};
        Assert.assertEquals(1, solution.findPeakElement(nums));
    }

    @Test
    public void findPeakElement3() throws Exception {
        Solution solution = new Solution();
        int[] nums = {2, 1};
        Assert.assertEquals(0, solution.findPeakElement(nums));
    }
}