package code.code150.question121;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxProfit() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    @Test
    public void maxProfit1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.maxProfit(new int[]{7,6,4,3,1}));
    }

}