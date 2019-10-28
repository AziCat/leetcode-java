package code.code100.question071;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void simplifyPath() {
        Solution solution = new Solution();
        Assert.assertEquals("/home", solution.simplifyPath("/home/"));
    }
    @Test
    public void simplifyPath1() {
        Solution solution = new Solution();
        Assert.assertEquals("/", solution.simplifyPath("/../"));
    }
    @Test
    public void simplifyPath12() {
        Solution solution = new Solution();
        Assert.assertEquals("/home/foo", solution.simplifyPath("/home//foo/"));
    }
    @Test
    public void simplifyPath121() {
        Solution solution = new Solution();
        Assert.assertEquals("/c", solution.simplifyPath("/a/../../b/../c//.//"));
    }
}