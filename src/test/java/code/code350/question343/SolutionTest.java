package code.code350.question343;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void integerBreak() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(12, solution.integerBreak(7));
    }

}