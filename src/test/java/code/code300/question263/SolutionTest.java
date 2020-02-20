package code.code300.question263;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isUgly() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isUgly(1));
    }

    @Test
    public void isUgly1() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isUgly(30));
    }

    @Test
    public void isUgly3() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isUgly(14));
    }
}