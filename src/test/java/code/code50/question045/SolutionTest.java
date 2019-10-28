package code.code50.question045;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void jump() {
        int[] nums = {2, 3, 1, 1, 4};
        Assert.assertEquals(2, solution.jump(nums));
    }

    @Test
    public void jump1() {
        int[] nums = {2, 3, 7, 4, 7, 2, 5, 1, 2, 4};
        Assert.assertEquals(2, solution.jump(nums));
    }

    @Test
    public void jump2() {
        int[] nums = {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5};
        Assert.assertEquals(5, solution.jump(nums));
    }

}