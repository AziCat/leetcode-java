package code.code100.question066;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void plusOne() {
        Solution solution = new Solution();
        int[] digits = {1, 2, 3};
        Assert.assertEquals("[1, 2, 4]", Arrays.toString(solution.plusOne(digits)));
    }
    @Test
    public void plusOne1() {
        Solution solution = new Solution();
        int[] digits = {1, 9, 9};
        Assert.assertEquals("[2, 0, 0]", Arrays.toString(solution.plusOne(digits)));
    }
    @Test
    public void plusOne2() {
        Solution solution = new Solution();
        int[] digits = {9, 9, 9};
        Assert.assertEquals("[1, 0, 0, 0]", Arrays.toString(solution.plusOne(digits)));
    }
}