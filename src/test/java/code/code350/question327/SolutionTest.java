package code.code350.question327;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void countRangeSum() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(3,
                solution.countRangeSum(new int[]{-2, 5, -1},
                        -2, 2));
    }

    @Test
    public void countRangeSum1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(4,
                solution.countRangeSum(new int[]{-2, 5, -1},
                        -2, 3));
    }
}