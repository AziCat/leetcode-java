package code.code50.question043;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void multiply() {
        Assert.assertEquals("100", solution.multiply("10", "10"));
    }

    @Test
    public void multiply1() {
        Assert.assertEquals("891", solution.multiply("99", "9"));
    }

    @Test
    public void multiply2() {
        Assert.assertEquals("0", solution.multiply("999", "0"));
    }
}