package code.code250.question238;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void productExceptSelf() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] output = solution.productExceptSelf(nums);
        Assert.assertEquals("[24, 12, 8, 6]", Arrays.toString(output));
    }

    @Test
    public void productExceptSelf1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int[] output = solution.productExceptSelf(nums);
        Assert.assertEquals("[120, 60, 40, 30, 24]", Arrays.toString(output));
    }
}