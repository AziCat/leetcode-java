package code.code400.question354;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxEnvelopes() throws Exception {
        Solution solution = new Solution();
        int[][] nums = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3},
        };
        Assert.assertEquals(3, solution.maxEnvelopes(nums));
    }

    @Test
    public void maxEnvelopes1() throws Exception {
        Solution solution = new Solution();
        int[][] nums = {
                {2, 3},
                {4, 3},
                {1, 1},
                {3, 2},
        };
        Assert.assertEquals(3, solution.maxEnvelopes(nums));
    }

    @Test
    public void maxEnvelopes2() throws Exception {
        Solution solution = new Solution();
        int[][] nums = {
                {1, 1},
        };
        Assert.assertEquals(1, solution.maxEnvelopes(nums));
    }
}