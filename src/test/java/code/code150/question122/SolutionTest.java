package code.code150.question122;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxProfit() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(7,solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }

}