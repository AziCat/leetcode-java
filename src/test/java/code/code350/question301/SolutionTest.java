package code.code350.question301;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void removeInvalidParentheses() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.removeInvalidParentheses(")((()()");
        Assert.assertEquals("[()(), (())]", ans.toString());
    }

    @Test
    public void removeInvalidParentheses1() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.removeInvalidParentheses(")(");
        Assert.assertEquals("[]", ans.toString());
    }

    @Test
    public void removeInvalidParentheses2() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.removeInvalidParentheses("()())()");
        Assert.assertEquals("[()()(), (())()]", ans.toString());
    }
}