package code.code350.question312;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxCoins() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(9, solution.maxCoins(new int[]{2, 3}));
    }

    @Test
    public void maxCoins1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.maxCoins(new int[]{3}));
    }

    @Test
    public void maxCoins12() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(167, solution.maxCoins(new int[]{3, 1, 5, 8}));
    }
}