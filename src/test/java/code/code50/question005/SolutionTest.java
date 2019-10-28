package code.code50.question005;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void longestPalindrome1() {
        String s = "babad";
        Solution solution = new Solution();
        Assert.assertEquals("bab", solution.longestPalindrome(s));
    }
    @Test
    public void longestPalindrome2() {
        String s = "cbbd";
        Solution solution = new Solution();
        Assert.assertEquals("bb", solution.longestPalindrome(s));
    }

    @Test
    public void longestPalindrome3() {
        String s = "";
        Solution solution = new Solution();
        Assert.assertEquals("", solution.longestPalindrome(s));
    }

    @Test
    public void longestPalindrome4() {
        String s = "abccbaf";
        Solution solution = new Solution();
        Assert.assertEquals("abccba", solution.longestPalindrome(s));
    }

    @Test
    public void longestPalindrome5() {
        String s = "ccc";
        Solution solution = new Solution();
        Assert.assertEquals("ccc", solution.longestPalindrome(s));
    }

    @Test
    public void longestPalindrome6() {
        String s = "a";
        Solution solution = new Solution();
        Assert.assertEquals("a", solution.longestPalindrome(s));
    }

    @Test
    public void longestPalindrome7() {
        String s = "aa";
        Solution solution = new Solution();
        Assert.assertEquals("aa", solution.longestPalindrome(s));
    }
}