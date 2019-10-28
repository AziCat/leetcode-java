package code.code100.question069;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void mySqrt() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.mySqrt(4));
    }

    @Test
    public void mySqrt1() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.mySqrt(1));
    }

    @Test
    public void mySqrt2() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.mySqrt(3));
    }

    @Test
    public void mySqrt3() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.mySqrt(9));
    }

    @Test
    public void mySqrt4() {
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.mySqrt(26));
    }

    @Test
    public void mySqrt6() {
        Solution solution = new Solution();
        Assert.assertEquals(99, solution.mySqrt(9801));
    }

    @Test
    public void mySqrt5() {
        Solution solution = new Solution();
        long l = 46339;
        System.out.println(l*l);
        Assert.assertEquals(46339, solution.mySqrt(2147395599));
    }
}