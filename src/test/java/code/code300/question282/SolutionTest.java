package code.code300.question282;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void addOperators() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.addOperators("123", 6);
        Assert.assertEquals("[1+2+3, 1*2*3]", ans.toString());
    }

    @Test
    public void addOperators1() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.addOperators("232", 8);
        Assert.assertEquals("[2+3*2, 2*3+2]", ans.toString());
    }

    @Test
    public void addOperators2() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.addOperators("105", 5);
        Assert.assertEquals("[1*0+5, 10-5]", ans.toString());
    }

    @Test
    public void addOperators3() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.addOperators("00", 0);
        Assert.assertEquals("[0+0, 0-0, 0*0]", ans.toString());
    }

    @Test
    public void addOperators4() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.addOperators("12345", 20);
        Assert.assertEquals("[1+2+3*4+5, 1+2-3+4*5, 1+2*3*4-5]", ans.toString());
    }

    @Test
    public void addOperators5() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.addOperators("000", 0);
        Assert.assertEquals("[0+0+0, 0+0-0, 0+0*0, 0-0+0, 0-0-0, 0-0*0, 0*0+0, 0*0-0, 0*0*0]", ans.toString());
    }
    @Test
    public void addOperators6() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.addOperators("2147483647", 2147483647);
        Assert.assertEquals("[2147483647]", ans.toString());
    }
}