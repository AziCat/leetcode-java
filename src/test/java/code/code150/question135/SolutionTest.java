package code.code150.question135;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void candy() throws Exception {
        Solution solution = new Solution();
        int[] ratings = new int[]{1, 0, 2};
        Assert.assertEquals(5, solution.candy(ratings));
    }

    @Test
    public void candy1() throws Exception {
        Solution solution = new Solution();
        int[] ratings = new int[]{1, 2, 2};
        Assert.assertEquals(4, solution.candy(ratings));
    }

    @Test
    public void candy2() throws Exception {
        Solution solution = new Solution();
        int[] ratings = new int[]{2, 3, 4, 3, 2, 1, 0};
        Assert.assertEquals(18, solution.candy(ratings));
    }

    @Test
    public void candy3() throws Exception {
        Solution solution = new Solution();
        int[] ratings = new int[]{10, 10, 10, 10, 10, 10};
        Assert.assertEquals(6, solution.candy(ratings));
    }

    @Test
    public void candy33() throws Exception {
        Solution solution = new Solution();
        int[] ratings = new int[]{1, 3, 4, 5, 2};
        Assert.assertEquals(11, solution.candy(ratings));
    }
}