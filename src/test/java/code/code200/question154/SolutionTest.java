package code.code200.question154;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findMin() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.findMin(new int[]{0, 0, 0, 1, 0}));
    }

    @Test
    public void findMin1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.findMin(new int[]{1, 2, 2, 0, 0, 1}));
    }

    @Test
    public void findMin11() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.findMin(new int[]{0, 0, 1, 1, 2, 2}));
    }

    @Test
    public void findMin111() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.findMin(new int[]{0, 1, 1, 2, 2, 0}));
    }

}