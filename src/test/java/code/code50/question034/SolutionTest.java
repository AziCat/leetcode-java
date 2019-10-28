package code.code50.question034;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void searchRange() {
        int[] nums = {1};
        Assert.assertEquals("[0, 0]", Arrays.toString(solution.searchRange(nums, 1)));
    }

    @Test
    public void searchRange1() {
        int[] nums = {};
        Assert.assertEquals("[-1, -1]", Arrays.toString(solution.searchRange(nums, 1)));
    }

    @Test
    public void searchRange2() {
        int[] nums = {1, 2};
        Assert.assertEquals("[-1, -1]", Arrays.toString(solution.searchRange(nums, 3)));
    }

    @Test
    public void searchRange3() {
        int[] nums = {1, 2};
        Assert.assertEquals("[-1, -1]", Arrays.toString(solution.searchRange(nums, 0)));
    }

    @Test
    public void searchRange34() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        Assert.assertEquals("[3, 4]", Arrays.toString(solution.searchRange(nums, 8)));
    }

    @Test
    public void searchRange314() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        Assert.assertEquals("[-1, -1]", Arrays.toString(solution.searchRange(nums, 6)));
    }

    @Test
    public void searchRange3114() {
        int[] nums = {5, 7, 7, 7, 7, 10};
        Assert.assertEquals("[1, 4]", Arrays.toString(solution.searchRange(nums, 7)));
    }

    @Test
    public void searchRange31124() {
        int[] nums = {7, 7, 7, 7, 7, 7};
        Assert.assertEquals("[0, 5]", Arrays.toString(solution.searchRange(nums, 7)));
    }

    @Test
    public void searchRange4() {
        int[] nums = {1, 2};
        Assert.assertEquals("[0, 0]", Arrays.toString(solution.searchRange(nums, 1)));
    }

    @Test
    public void searchRange54() {
        int[] nums = {1, 2};
        Assert.assertEquals("[1, 1]", Arrays.toString(solution.searchRange(nums, 2)));
    }

    @Test
    public void searchRange514() {
        int[] nums = {1, 2, 2, 2, 3};
        Assert.assertEquals("[4, 4]", Arrays.toString(solution.searchRange(nums, 3)));
    }
}