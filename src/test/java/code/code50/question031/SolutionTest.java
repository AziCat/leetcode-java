package code.code50.question031;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void nextPermutation() {
        int[] nums = {2, 5, 1, 4, 3};
        solution.nextPermutation(nums);
        Assert.assertEquals("[2, 5, 3, 1, 4]", Arrays.toString(nums));
    }

    @Test
    public void nextPermutation1() {
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        Assert.assertEquals("[1, 3, 2]", Arrays.toString(nums));
    }

    @Test
    public void nextPermutation2() {
        int[] nums = {1, 1, 5};
        solution.nextPermutation(nums);
        Assert.assertEquals("[1, 5, 1]", Arrays.toString(nums));
    }

    @Test
    public void nextPermutation3() {
        int[] nums = {3, 2, 1};
        solution.nextPermutation(nums);
        Assert.assertEquals("[1, 2, 3]", Arrays.toString(nums));
    }

    @Test
    public void nextPermutation4() {
        int[] nums = {1, 5, 4, 3, 2};
        solution.nextPermutation(nums);
        Assert.assertEquals("[2, 1, 3, 4, 5]", Arrays.toString(nums));
    }
}