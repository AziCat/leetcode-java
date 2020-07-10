package code.code400.question365;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void canMeasureWater() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.canMeasureWater(3, 5, 4));
    }
    @Test
    public void canMeasureWater1() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.canMeasureWater(2, 6, 5));
    }
}