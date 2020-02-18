package code.code300.question258;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void addDigits() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.addDigits(38));
    }

    @Test
    public void addDigits1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.addDigits(55));
    }

    @Test
    public void addDigits2() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.addDigits(0));
    }
}