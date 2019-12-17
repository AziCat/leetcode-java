package code.code150.question149;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxPoints() throws Exception {
        Solution solution = new Solution();
        int[][] points = {};
        Assert.assertEquals(0, solution.maxPoints(points));
    }

    @Test
    public void maxPoints1() throws Exception {
        Solution solution = new Solution();
        int[][] points = {
                {1, 1}, {2, 2}, {1, 1}
        };
        Assert.assertEquals(3, solution.maxPoints(points));
    }

    @Test
    public void maxPoints12() throws Exception {
        Solution solution = new Solution();
        int[][] points = {
                {1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}
        };
        Assert.assertEquals(4, solution.maxPoints(points));
    }
    @Test
    public void maxPoints212() throws Exception {
        Solution solution = new Solution();
        int[][] points = {
                {3, 10}, {0, 2}, {3, 10}, {0, 2}
        };
        Assert.assertEquals(4, solution.maxPoints(points));
    }
}