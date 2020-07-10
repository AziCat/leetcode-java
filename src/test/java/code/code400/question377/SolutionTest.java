package code.code400.question377;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void combinationSum4() {
        Solution solution = new Solution();
        Assert.assertEquals(7, solution.combinationSum4(new int[]{1, 2, 3}, 4));
    }
    @Test
    public void combinationSum41() {
        Solution solution = new Solution();
        Assert.assertEquals(7, solution.combinationSum4(new int[]{1, 3, 2}, 4));
    }
}