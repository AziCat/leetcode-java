package code.code50.question027;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void removeElement() {
        int[] nums = {3, 2, 2, 3};
        int count = solution.removeElement(nums, 3);
        Assert.assertEquals(2, count);

    }

    @Test
    public void removeElement1() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int count = solution.removeElement(nums, 2);
        Assert.assertEquals(5, count);

    }
}