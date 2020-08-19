package code.code400.question387;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void firstUniqChar() {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.firstUniqChar("leetcode"));
    }
}