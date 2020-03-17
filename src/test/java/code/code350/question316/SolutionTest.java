package code.code350.question316;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void removeDuplicateLetters() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("acdb", solution.removeDuplicateLetters("cbacdcbc"));
    }

    @Test
    public void removeDuplicateLetters1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("abc", solution.removeDuplicateLetters("bcabc"));
    }
}