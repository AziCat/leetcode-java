package code.code50.question018;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void fourSum() {
        //int[] nums = {1, 0, -1, 0, -2, 2};
        //int[] nums = {0, 0, 0, 0, -2, 2};
        //int[] nums = {0, 0, 0, 0};
        //int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        //int[] nums = {-4, -3, -2, -1, 0, 0, 1, 2, 3, 4};
        //int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        int[] nums = {-1, -5, -5, -3, 2, 5, 0, 4};
        List list = solution.fourSum(nums, -7);
        Assert.assertEquals("[[-5, -5, -1, 4], [-5, -3, -1, 2]]", list.toString());
    }
    @Test
    public void fourSum1() {
        //int[] nums = {1, 0, -1, 0, -2, 2};
        //int[] nums = {0, 0, 0, 0, -2, 2};
        //int[] nums = {0, 0, 0, 0};
        //int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        List list = solution.fourSum(nums, -11);
        Assert.assertEquals("[[-5, -4, -3, 1]]", list.toString());
    }
}