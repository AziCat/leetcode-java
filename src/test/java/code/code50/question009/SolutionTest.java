package code.code50.question009;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void isPalindrome() {
        Assert.assertTrue(solution.isPalindrome(121));
    }
    @Test
    public void isPalindrome1() {
        Assert.assertTrue(!solution.isPalindrome(-121));
    }
    @Test
    public void isPalindrome2() {
        Assert.assertTrue(solution.isPalindrome(5));
    }
    @Test
    public void isPalindrome3() {
        Assert.assertTrue(!solution.isPalindrome(100));
    }
}