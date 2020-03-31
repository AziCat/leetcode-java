package code.code350.question322;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void coinChange() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.coinChange(new int[]{1, 2, 5}, 11));
    }

    @Test
    public void coinChange1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(-1, solution.coinChange(new int[]{2}, 3));
    }

    @Test
    public void coinChange3() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.coinChange(new int[]{3, 5}, 6));
    }

    @Test
    public void coinChange4() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.coinChange(new int[]{3, 5}, 11));
    }

    @Test
    public void coinChange5() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(20, solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    @Test
    public void coinChange6() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.coinChange(new int[]{1, 2, 5, 6}, 15));
    }
}