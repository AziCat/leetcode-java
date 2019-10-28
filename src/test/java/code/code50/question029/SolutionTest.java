package code.code50.question029;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void divide() {
        Assert.assertEquals(3 / 4, solution.divide(3, 4));
    }

    @Test
    public void divide1() {
        Assert.assertEquals(8 / 4, solution.divide(8, 4));
    }

    @Test
    public void divide2() {
        Assert.assertEquals(10 / 3, solution.divide(10, 3));
    }

    @Test
    public void divide3() {
        Assert.assertEquals(7 / -2, solution.divide(7, -2));
    }

    @Test
    public void divide4() {
        Assert.assertEquals(2147483647, solution.divide(-2147483648, -1));
    }

    @Test
    public void divide5() {
        Assert.assertEquals(55 / 4, solution.divide(55, 4));
    }

    @Test
    public void divide6() {
        Assert.assertEquals(55 / 5, solution.divide(55, 5));
    }
}