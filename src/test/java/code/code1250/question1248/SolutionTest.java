package code.code1250.question1248;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void numberOfSubarrays() throws Exception {
        int[] nums = {1, 1, 2, 1, 1};
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.numberOfSubarrays(nums, 3));
    }

    @Test
    public void numberOfSubarrays1() throws Exception {
        int[] nums = {2, 4, 6};
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.numberOfSubarrays(nums, 1));
    }

    @Test
    public void numberOfSubarrays2() throws Exception {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        Solution solution = new Solution();
        Assert.assertEquals(16, solution.numberOfSubarrays(nums, 2));
    }
}