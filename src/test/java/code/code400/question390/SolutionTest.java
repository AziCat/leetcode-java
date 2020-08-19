package code.code400.question390;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lastRemaining() {
        Solution solution = new Solution();
        Assert.assertEquals(6, solution.lastRemaining(9));
    }
}