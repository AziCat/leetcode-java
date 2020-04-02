package code.code350.question334;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void increasingTriplet() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void increasingTriplet1() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }

}