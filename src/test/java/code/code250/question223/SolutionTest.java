package code.code250.question223;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void computeArea() throws Exception {
        Solution solution = new Solution();
        int ans = solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        Assert.assertEquals(45, ans);
    }

}