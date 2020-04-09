package code.code350.question345;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void reverseVowels() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("leotcede", solution.reverseVowels("leetcode"));
    }

    @Test
    public void reverseVowels1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("holle", solution.reverseVowels("hello"));
    }
}