package code.code250.question214;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void shortestPalindrome() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("aaacbcaaa", solution.shortestPalindrome("acbcaaa"));
    }

    @Test
    public void shortestPalindrome1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("a", solution.shortestPalindrome("a"));
    }

    @Test
    public void shortestPalindrome2() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("", solution.shortestPalindrome(""));
    }

    @Test
    public void shortestPalindrome3() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("cbabc", solution.shortestPalindrome("abc"));
    }

    @Test
    public void shortestPalindrome4() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("aaacecaaa", solution.shortestPalindrome("aacecaaa"));
    }

    @Test
    public void shortestPalindrome5() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("adcbabcda", solution.shortestPalindrome("abcda"));
    }
}