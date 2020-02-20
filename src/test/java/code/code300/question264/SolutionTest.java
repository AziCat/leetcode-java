package code.code300.question264;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void nthUglyNumber() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.nthUglyNumber(1));
    }

    @Test
    public void nthUglyNumber1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.nthUglyNumber(2));
    }

    @Test
    public void nthUglyNumber2() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.nthUglyNumber(3));
    }

    @Test
    public void nthUglyNumber3() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.nthUglyNumber(4));
    }

    @Test
    public void nthUglyNumber5() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(12, solution.nthUglyNumber(10));
    }
}