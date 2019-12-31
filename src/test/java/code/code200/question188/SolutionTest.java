package code.code200.question188;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxProfit() throws Exception {
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
        Assert.assertEquals(7, maxProfit);
    }

    @Test
    public void maxProfit1() throws Exception {
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(2, new int[]{3, 2, 1, 0, 0, 0});
        Assert.assertEquals(0, maxProfit);
    }

    @Test
    public void maxProfit2() throws Exception {
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3, 9});
        Assert.assertEquals(13, maxProfit);
    }

    @Test
    public void maxProfit3() throws Exception {
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(4, new int[]{3, 2, 6, 5, 0, 3});
        Assert.assertEquals(7, maxProfit);
    }

    @Test
    public void maxProfit31() throws Exception {
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(41, new int[]{3, 2, 6, 5, 0, 3, 9, 19});
        Assert.assertEquals(23, maxProfit);
    }
    @Test
    public void maxProfit311() throws Exception {
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(2, new int[]{});
        Assert.assertEquals(0, maxProfit);
    }



}