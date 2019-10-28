package code.code100.question087;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isScramble() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isScramble("eat", "tea"));
    }
    @Test
    public void isScramble1() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isScramble("great", "rgeat"));
    }
    @Test
    public void isScramble2() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isScramble("abcde", "caebd"));
    }
}