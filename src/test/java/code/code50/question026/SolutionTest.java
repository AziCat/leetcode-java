package code.code50.question026;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void removeDuplicates() {
        int[] nums = {1, 1, 2};
        int count = solution.removeDuplicates(nums);
        Assert.assertEquals(2, count);
    }

    @Test
    public void removeDuplicates1() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = solution.removeDuplicates(nums);
        Assert.assertEquals(5, count);
    }
}