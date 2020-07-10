package code.code400.question375;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getMoneyAmount() {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.getMoneyAmount(0));
    }
    @Test
    public void getMoneyAmount1() {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.getMoneyAmount(1));
    }
    @Test
    public void getMoneyAmount2() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.getMoneyAmount(2));
    }
    @Test
    public void getMoneyAmount23() {
        Solution solution = new Solution();
        Assert.assertEquals(16, solution.getMoneyAmount(10));
    }
}