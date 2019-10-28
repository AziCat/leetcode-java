package code.code100.question053;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void maxSubArray() {
        Assert.assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void maxSubArray1() {
        Assert.assertEquals(10, solution.maxSubArray(new int[]{-2, 1, 3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void maxSubArray2() {
        Assert.assertEquals(10, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -9, 10}));
    }

    @Test
    public void maxSubArray3() {
        Assert.assertEquals(0, solution.maxSubArray(new int[]{-2, -3, -1, -9, 0}));
    }
}