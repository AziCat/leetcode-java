package code.code400.question367;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isPerfectSquare() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isPerfectSquare(808201));
    }
    @Test
    public void isPerfectSquare2() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isPerfectSquare(81));
    }
    @Test
    public void isPerfectSquare1() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isPerfectSquare(19));
    }
}