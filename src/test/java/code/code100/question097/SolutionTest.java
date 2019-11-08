package code.code100.question097;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isInterleave() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    @Test
    public void isInterleave33() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isInterleave("aabe", "dbc", "aadbcbe"));
    }

    @Test
    public void isInterleave313() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isInterleave("", "", ""));
    }
    @Test
    public void isInterleave3() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isInterleave("aabe", "dbc", "aadbebc"));
    }

    @Test
    public void isInterleave1() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(!solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
    @Test
    public void isInterleave21() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(!solution.isInterleave("a", "b", "a"));
    }

    @Test
    public void isInterleave211() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(!solution.isInterleave("db", "b", "cbb"));
    }

}