package code.code100.question080;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void removeDuplicates() {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 2, 2, 3, 3, 3, 3, 3, 4, 5, 5, 5};
        Assert.assertEquals(10, solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void removeDuplicates1() {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        Assert.assertEquals(7, solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void removeDuplicates2() {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        Assert.assertEquals(2, solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}