package code.code250.question220;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void containsNearbyAlmostDuplicate() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        Assert.assertTrue(solution.containsNearbyAlmostDuplicate(nums, 3, 0));
    }

    @Test
    public void containsNearbyAlmostDuplicate1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 0, 1, 1};
        Assert.assertTrue(solution.containsNearbyAlmostDuplicate(nums, 1, 2));
    }

    @Test
    public void containsNearbyAlmostDuplicate2() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 5, 9, 1, 5, 9};
        Assert.assertFalse(solution.containsNearbyAlmostDuplicate(nums, 2, 3));
    }

    @Test
    public void containsNearbyAlmostDuplicate3() throws Exception {
        Solution solution = new Solution();
        int[] nums = {-1, -1};
        Assert.assertFalse(solution.containsNearbyAlmostDuplicate(nums, 1, -1));
    }

    @Test
    public void containsNearbyAlmostDuplicate4() throws Exception {
        Solution solution = new Solution();
        int[] nums = {-1, -1};
        Assert.assertFalse(solution.containsNearbyAlmostDuplicate(nums, 1, -1));
    }

}