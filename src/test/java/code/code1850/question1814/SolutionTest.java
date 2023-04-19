package code.code1850.question1814;


import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.countNicePairs(new int[]{42, 11, 1, 97}));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }
}