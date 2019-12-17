package code.code150.question150;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void evalRPN() throws Exception {
        Solution solution = new Solution();
        String[] token = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Assert.assertEquals(22, solution.evalRPN(token));
    }

    @Test
    public void evalRPN1() throws Exception {
        Solution solution = new Solution();
        String[] token = {"4", "13", "5", "/", "+"};
        Assert.assertEquals(6, solution.evalRPN(token));
    }
}