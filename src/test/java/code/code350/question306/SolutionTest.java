package code.code350.question306;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isAdditiveNumber() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isAdditiveNumber("112358"));
    }

    @Test
    public void isAdditiveNumber2() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isAdditiveNumber("199100199"));
    }

    @Test
    public void isAdditiveNumber4() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isAdditiveNumber("123"));
    }

    @Test
    public void isAdditiveNumber3() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isAdditiveNumber("123123246"));
    }

    @Test
    public void isAdditiveNumber1() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isAdditiveNumber("112359"));
    }

    @Test
    public void isAdditiveNumber11() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isAdditiveNumber("1023"));
    }
    @Test
    public void isAdditiveNumber111() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isAdditiveNumber("0235813"));
    }
}