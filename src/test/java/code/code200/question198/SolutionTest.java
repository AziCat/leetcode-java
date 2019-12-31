package code.code200.question198;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void rob() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.rob(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void rob1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(12, solution.rob(new int[]{2, 7, 9, 3, 1}));
    }

    @Test
    public void rob2() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.rob(new int[]{2, 1, 2, 3}));
    }

    @Test
    public void rob21() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(20, solution.rob(new int[]{2, 9, 2, 3, 6, 8}));
    }

}