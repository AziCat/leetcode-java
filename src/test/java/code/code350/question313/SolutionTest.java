package code.code350.question313;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void nthSuperUglyNumber() throws Exception {
        Solution solution = new Solution();
        int ans = solution.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        Assert.assertEquals(32, ans);
    }

    @Test
    public void nthSuperUglyNumber1() throws Exception {
        Solution solution = new Solution();
        int ans = solution.nthSuperUglyNumber(3, new int[]{2, 7, 13, 19});
        Assert.assertEquals(4, ans);
    }

    @Test
    public void nthSuperUglyNumber12() throws Exception {
        Solution solution = new Solution();
        int ans = solution.nthSuperUglyNumber(11, new int[]{2, 7, 13, 19});
        Assert.assertEquals(28, ans);
    }
}