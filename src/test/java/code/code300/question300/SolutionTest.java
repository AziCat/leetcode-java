package code.code300.question300;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void lengthOfLIS() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.lengthOfLIS(new int[]{1, 2, 0, 3, -1, 6, 5}));
    }

}