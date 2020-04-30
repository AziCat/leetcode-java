package code.interview.question56;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void singleNumbers() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        int[] ans = solution.singleNumbers(nums);
        Assert.assertTrue("[2, 10]".equals(Arrays.toString(ans)) || "[10, 2]".equals(Arrays.toString(ans)));
    }
}