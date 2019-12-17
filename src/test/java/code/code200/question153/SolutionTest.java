package code.code200.question153;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findMin() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.findMin(new int[]{5, 1, 2, 3, 4}));
    }

    @Test
    public void findMin1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.findMin(new int[]{4, 5, 1, 2, 3}));
    }

    @Test
    public void findMin2() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.findMin(new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    public void findMin3() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.findMin(new int[]{2, 3, 4, 5, 1}));
    }

    @Test
    public void findMin4() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.findMin(new int[]{1, 2, 3, 4, 5}));
    }

}