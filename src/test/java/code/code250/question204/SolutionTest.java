package code.code250.question204;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void countPrimes() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.countPrimes(4));
    }

    @Test
    public void countPrimes1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.countPrimes(10));
    }
}