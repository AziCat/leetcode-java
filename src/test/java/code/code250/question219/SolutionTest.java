package code.code250.question219;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void containsNearbyDuplicate() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        Assert.assertTrue(solution.containsNearbyDuplicate(nums, 3));
    }

    @Test
    public void containsNearbyDuplicate1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 0, 1, 1};
        Assert.assertTrue(solution.containsNearbyDuplicate(nums, 1));
    }

    @Test
    public void containsNearbyDuplicate2() throws Exception {
        Solution solution = new Solution();
        int[] nums = {99, 99};
        Assert.assertTrue(solution.containsNearbyDuplicate(nums, 2));
    }


}