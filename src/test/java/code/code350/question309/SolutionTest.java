package code.code350.question309;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxProfit() throws Exception {
        Solution solution = new Solution();
        int[] prices = {1, 2, 3, 0, 2};
        Assert.assertEquals(3, solution.maxProfit(prices));
    }

}