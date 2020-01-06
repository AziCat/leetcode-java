package code.code250.question202;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isHappy() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isHappy(19));
    }

    @Test
    public void isHappy12() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isHappy(7));
    }

    @Test
    public void isHappy1() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isHappy(4));
    }

    @Test
    public void isHappy2() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isHappy(0));
    }

}