package code.code200.question189;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void rotate() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        solution.rotate(nums, 2);
        Assert.assertEquals("[4, 5, 1, 2, 3]", Arrays.toString(nums));
    }

    @Test
    public void rotate1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        solution.rotate(nums, 2);
        Assert.assertEquals("[3, 4, 1, 2]", Arrays.toString(nums));
    }


    @Test
    public void rotate21() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
        solution.rotate(nums, 38);
        Assert.assertEquals("[17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]", Arrays.toString(nums));
    }

    @Test
    public void rotate121() throws Exception {
        Solution solution = new Solution();
        int[] nums = {12, 13, 14, 15, 16, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        solution.rotate(nums, 11);
        Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]", Arrays.toString(nums));
    }
}