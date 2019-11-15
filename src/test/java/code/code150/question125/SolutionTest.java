package code.code150.question125;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isPalindrome() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void isPalindrome1() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isPalindrome("0P"));
    }

}