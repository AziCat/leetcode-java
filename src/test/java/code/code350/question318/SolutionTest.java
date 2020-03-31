package code.code350.question318;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxProduct() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.maxProduct(new String[]{"abac"}));
    }

    @Test
    public void maxProduct1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(16, solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }
}