package code.code350.question349;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void intersection() throws Exception {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 4, 2, 3};
        int[] nums2 = {3, 2, 4};
        int[] ans = solution.intersection(nums1, nums2);
        Assert.assertEquals("[2, 3, 4]", Arrays.toString(ans));
    }

}