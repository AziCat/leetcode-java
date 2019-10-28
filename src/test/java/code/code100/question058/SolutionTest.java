package code.code100.question058;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lengthOfLastWord() {
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.lengthOfLastWord("Hello World"));
    }

    @Test
    public void lengthOfLastWord1() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.lengthOfLastWord("Hello World abc"));
    }

    @Test
    public void lengthOfLastWord3() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.lengthOfLastWord("Hello World abc    "));
    }

    @Test
    public void lengthOfLastWord4() {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.lengthOfLastWord(""));
    }

    @Test
    public void lengthOfLastWord24() {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.lengthOfLastWord(" "));
    }
}