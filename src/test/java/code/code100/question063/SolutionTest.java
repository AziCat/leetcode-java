package code.code100.question063;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void uniquePathsWithObstacles() {
        Solution solution = new Solution();
        int[][] a = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 0, 0}
        };
        Assert.assertEquals(3, solution.uniquePathsWithObstacles(a));
    }

    @Test
    public void uniquePathsWithObstacles1() {
        Solution solution = new Solution();
        int[][] a = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        Assert.assertEquals(2, solution.uniquePathsWithObstacles(a));
    }

    @Test
    public void uniquePathsWithObstacles13() {
        Solution solution = new Solution();
        int[][] a = {
                {1}
        };
        Assert.assertEquals(0, solution.uniquePathsWithObstacles(a));
    }
}