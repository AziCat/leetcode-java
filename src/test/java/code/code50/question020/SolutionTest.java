package code.code50.question020;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void isValid() {
        Assert.assertTrue(solution.isValid("()"));
    }

    @Test
    public void isValid1() {
        Assert.assertTrue(solution.isValid("()[]{}"));
    }

    @Test
    public void isValid2() {
        Assert.assertFalse(solution.isValid("(]"));
    }

    @Test
    public void isValid4() {
        Assert.assertFalse(solution.isValid("([)]"));
    }


    @Test
    public void isValid5() {
        Assert.assertTrue(solution.isValid("{[]}"));
    }

    @Test
    public void isValid6() {
        Assert.assertTrue(solution.isValid("(([]){})"));
    }
    @Test
    public void isValid7() {
        Assert.assertFalse(solution.isValid("(("));
    }
}