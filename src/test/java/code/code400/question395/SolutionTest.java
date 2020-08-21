package code.code400.question395;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void longestSubstring() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.longestSubstring("aaabb", 3));
    }
}