package code.code1100.question1052;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int result = solution.maxSatisfied(
                new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1},
                3
        );
        Assert.assertEquals(16, result);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int result = solution.maxSatisfied(
                new int[]{1},
                new int[]{0},
                1
        );
        Assert.assertEquals(1, result);
    }

}