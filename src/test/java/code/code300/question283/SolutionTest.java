package code.code300.question283;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void moveZeroes() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 0, 0, 2, 3, 0, 0, 4};
        solution.moveZeroes(nums);
        Assert.assertEquals("[1, 2, 3, 4, 0, 0, 0, 0]", Arrays.toString(nums));

    }

    @Test
    public void moveZeroes1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 0, 0};
        solution.moveZeroes(nums);
        Assert.assertEquals("[1, 2, 0, 0]", Arrays.toString(nums));

    }
    @Test
    public void moveZeroes2() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2};
        solution.moveZeroes(nums);
        Assert.assertEquals("[1, 2]", Arrays.toString(nums));

    }
}