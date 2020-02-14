package code.code250.question239;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxSlidingWindow() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ans = solution.maxSlidingWindow(nums, 3);
        Assert.assertEquals("[3, 3, 5, 5, 6, 7]", Arrays.toString(ans));

    }

}