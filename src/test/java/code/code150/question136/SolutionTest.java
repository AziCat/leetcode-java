package code.code150.question136;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void singleNumber() throws Exception {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 1, 2, 1, 2};
        Assert.assertEquals(4, solution.singleNumber(nums));
    }

}