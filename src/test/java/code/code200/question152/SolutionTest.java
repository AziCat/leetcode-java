package code.code200.question152;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxProduct() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(6, solution.maxProduct(new int[]{2, 3, 0, -5, 1, 2}));
    }

    @Test
    public void maxProduct1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.maxProduct(new int[]{0, 0, 0, -5, 0, 0}));
    }

}