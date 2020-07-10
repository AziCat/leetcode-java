package code.code400.question357;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void countNumbersWithUniqueDigits0() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.countNumbersWithUniqueDigits(0));
    }

    @Test
    public void countNumbersWithUniqueDigits() {
        Solution solution = new Solution();
        Assert.assertEquals(10, solution.countNumbersWithUniqueDigits(1));
    }

    @Test
    public void countNumbersWithUniqueDigits2() {
        Solution solution = new Solution();
        Assert.assertEquals(91, solution.countNumbersWithUniqueDigits(2));
    }
}