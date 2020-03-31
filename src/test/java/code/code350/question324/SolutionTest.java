package code.code350.question324;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void wiggleSort() throws Exception {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        Assert.assertEquals("[3, 6, 2, 5, 1, 4]", Arrays.toString(nums));
    }

    @Test
    public void wiggleSort1() throws Exception {
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        Assert.assertEquals("[3, 5, 2, 4, 1]", Arrays.toString(nums));
    }

    @Test
    public void wiggleSort2() throws Exception {
        int[] nums = {1, 2, 2, 1, 1};
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        Assert.assertEquals("[1, 2, 1, 2, 1]", Arrays.toString(nums));
    }

    @Test
    public void wiggleSort12() throws Exception {
        int[] nums = {1, 3, 2, 2, 3, 1};
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        Assert.assertEquals("[2, 3, 1, 3, 1, 2]", Arrays.toString(nums));
    }

    @Test
    public void wiggleSort112() throws Exception {
        int[] nums = {1};
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        Assert.assertEquals("[1]", Arrays.toString(nums));
    }

    @Test
    public void wiggleSort22() throws Exception {
        int[] nums = {2, 1};
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        Assert.assertEquals("[1, 2]", Arrays.toString(nums));
    }

    @Test
    public void wiggleSort212() throws Exception {
        int[] nums = {2, 1, 3};
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        Assert.assertEquals("[2, 3, 1]", Arrays.toString(nums));
    }

    @Test
    public void wiggleSort2122() throws Exception {
        int[] nums = {4, 5, 5, 6};
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        Assert.assertEquals("[5, 6, 4, 5]", Arrays.toString(nums));
    }

    @Test
    public void wiggleSort21322() throws Exception {
        int[] nums = {5, 3, 1, 2, 6, 7, 8, 5, 5};
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        Assert.assertEquals("[5, 8, 5, 7, 3, 6, 2, 5, 1]", Arrays.toString(nums));
    }
}