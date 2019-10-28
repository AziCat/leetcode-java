package code.code100.question064;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minPathSum() {
        Solution solution = new Solution();
        int[][] gird = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Assert.assertEquals(7, solution.minPathSum(gird));
    }

    @Test
    public void minPathSum1() {
        Solution solution = new Solution();
        int[][] gird = {
                {1, 3, 1},
                {1, 5, 1},
                {14, 2, 12},
                {4, 2, 1}
        };
        Assert.assertEquals(12, solution.minPathSum(gird));
    }
}