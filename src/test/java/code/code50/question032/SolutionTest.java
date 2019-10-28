package code.code50.question032;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void longestValidParentheses() {
        Assert.assertEquals(10, solution.longestValidParentheses(")()()((()()()())("));
    }

    @Test
    public void longestValidParentheses1() {
        Assert.assertEquals(2, solution.longestValidParentheses("(()"));
    }

    @Test
    public void longestValidParentheses2() {
        Assert.assertEquals(4, solution.longestValidParentheses(")()())"));
    }

    @Test
    public void longestValidParentheses3() {
        Assert.assertEquals(0, solution.longestValidParentheses("(((((("));
    }

    @Test
    public void longestValidParentheses4() {
        Assert.assertEquals(0, solution.longestValidParentheses("))(((((("));
    }

    @Test
    public void longestValidParentheses5() {
        Assert.assertEquals(16, solution.longestValidParentheses("))(())((((()))))()"));
    }

    @Test
    public void longestValidParentheses6() {
        Assert.assertEquals(6, solution.longestValidParentheses("(()())"));
    }
}