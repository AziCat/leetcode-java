package code.code150.question128;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void longestConsecutive() throws Exception {
        Solution solution = new Solution();
        int ans = solution.longestConsecutive(new int[]{ -4, 1, -1, -3,  100, 4, 200, 1, 3, 2});
        Assert.assertEquals(4, ans);
    }

}