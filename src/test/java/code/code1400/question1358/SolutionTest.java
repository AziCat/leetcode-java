package code.code1400.question1358;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void numberOfSubstrings() {
        Solution solution = new Solution();
        Assert.assertEquals(10, solution.numberOfSubstrings("abcabc"));
    }

    @Test
    public void numberOfSubstrings1() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.numberOfSubstrings("aaacb"));
    }

    @Test
    public void numberOfSubstrings2() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.numberOfSubstrings("abc"));
    }
}