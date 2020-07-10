package code.code400.question376;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void wiggleMaxLength() {
        Solution solution = new Solution();
        Assert.assertEquals(7, solution.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }

    @Test
    public void wiggleMaxLength1() {
        Solution solution = new Solution();
        Assert.assertEquals(6, solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }

    @Test
    public void wiggleMaxLength12() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    public void wiggleMaxLength123() {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.wiggleMaxLength(new int[]{}));
    }

    @Test
    public void wiggleMaxLength124() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.wiggleMaxLength(new int[]{1, 1, 2}));
    }

    @Test
    public void wiggleMaxLength125() {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.wiggleMaxLength(new int[]{2, 2, 1, 2, 1}));
    }
    @Test
    public void wiggleMaxLength122() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.wiggleMaxLength(new int[]{1,1}));
    }
}