package code.code250.question215;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findKthLargest() throws Exception {
        Solution solution = new Solution();
        int[] nums = {5, 1, 6, 3, 4, 2, 7};
        Assert.assertEquals(6, solution.findKthLargest(nums, 2));
    }

}