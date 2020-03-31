package code.code350.question321;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void maxNumber() throws Exception {
        Solution solution = new Solution();
        int[] num1 = {3, 4, 6, 5};
        int[] num2 = {9, 1, 2, 5, 8, 3};
        Assert.assertEquals("[9, 8, 6, 5, 3]", Arrays.toString(solution.maxNumber(num1, num2, 5)));
    }

    @Test
    public void maxNumber1() throws Exception {
        Solution solution = new Solution();
        int[] num1 = {6, 7};
        int[] num2 = {6, 0, 4};
        Assert.assertEquals("[6, 7, 6, 0, 4]", Arrays.toString(solution.maxNumber(num1, num2, 5)));
    }
}