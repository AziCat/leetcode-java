package code.code300.question287;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findDuplicate() throws Exception {
        Solution solution = new Solution();
        int[] nums = {3, 1, 3, 4, 2};
        int ans = solution.findDuplicate(nums);
        Assert.assertEquals(ans, 3);
    }

    @Test
    public void findDuplicate1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 2, 4, 5, 6};
        int ans = solution.findDuplicate(nums);
        Assert.assertEquals(ans, 2);
    }

}