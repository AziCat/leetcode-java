package code.code250.question217;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void containsDuplicate() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.containsDuplicate(new int[]{1, 2, 3, 4, 1}));
    }

    @Test
    public void containsDuplicate1() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

}