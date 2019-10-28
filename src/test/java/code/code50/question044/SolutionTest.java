package code.code50.question044;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void isMatch() {
        Assert.assertFalse(solution.isMatch("aa", "a"));
    }

    @Test
    public void isMatch1() {
        Assert.assertTrue(solution.isMatch("aabbvf", "aa*"));
    }

    @Test
    public void isMatch12() {
        Assert.assertFalse(solution.isMatch("cb", "?a"));
    }

    @Test
    public void isMatch122() {
        Assert.assertTrue(solution.isMatch("adceb", "*a*b"));
    }

    @Test
    public void isMatch1s22() {
        Assert.assertTrue(solution.isMatch("", ""));
    }

    @Test
    public void isMatch1as22() {
        Assert.assertFalse(solution.isMatch("a", ""));
    }

    @Test
    public void isMatch1a22() {
        Assert.assertFalse(solution.isMatch("", "a"));
    }

    @Test
    public void isMatch1222() {
        Assert.assertFalse(solution.isMatch("acdcb", "a*c?b"));
    }

    @Test
    public void isMatch122s2() {
        Assert.assertTrue(solution.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
    }

    @Test
    public void isMatch122ss2() {
        Assert.assertTrue(solution.isMatch("abefcdgfiescdfimde", "ab*cd?i*de"));
    }

    @Test
    public void isMatch12s2() {
        Assert.assertFalse(solution.isMatch("aab", "c*a*b"));
    }

    @Test
    public void isMatch1s2s2() {
        Assert.assertTrue(solution.isMatch("caab", "c*a*b"));
    }

    @Test
    public void isMatch1s2ss2() {
        Assert.assertTrue(solution.isMatch("caakceeaazb", "c*aaz*b"));
    }

    @Test
    public void isMatch1aa2() {
        Assert.assertFalse(solution.isMatch("zacabz", "*a?b*"));
    }

    @Test
    public void isMatch1taa2() {
        Assert.assertTrue(solution.isMatch("a", "a*"));
    }

    @Test
    public void isMatch1staa2() {
        Assert.assertTrue(solution.isMatch("aaaa", "**a"));
    }

    @Test
    public void isMatch1sstaa2() {
        Assert.assertFalse(solution.isMatch("aaaa", "**b"));
    }

    @Test
    public void isMatch1stsaa2() {
        Assert.assertTrue(solution.isMatch("abva", "**a"));
    }

    @Test
    public void isMatch1staad2() {
        Assert.assertTrue(solution.isMatch("", "*"));
    }

    @Test
    public void isMatch1staasd2() {
        Assert.assertTrue(solution.isMatch("mississippi", "m*issip*"));
    }


    @Test
    public void isMatch1stsaad2() {
        Assert.assertFalse(solution.isMatch("mississippi", "m??*ss*?i*pi"));
    }

    @Test
    public void isMatch1stsfaad2() {
        Assert.assertFalse(solution.isMatch("aaab", "ab*"));
    }

    @Test
    public void isMatch1stssaad2() {
        Assert.assertFalse(solution.isMatch("a", "a***a"));
    }
}