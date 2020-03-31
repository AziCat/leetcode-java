package code.code350.question329;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void longestIncreasingPath() throws Exception {
        Solution solution = new Solution();
        int[][] matrix = {
                {7, 8, 1},
                {6, 9, 2},
                {5, 4, 3},
        };
        Assert.assertEquals(9, solution.longestIncreasingPath(matrix));
    }

    @Test
    public void longestIncreasingPath1() throws Exception {
        Solution solution = new Solution();
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1},
        };
        Assert.assertEquals(4, solution.longestIncreasingPath(matrix));
    }

    @Test
    public void longestIncreasingPath2() throws Exception {
        Solution solution = new Solution();
        int[][] matrix = {
        };
        Assert.assertEquals(0, solution.longestIncreasingPath(matrix));
    }

    @Test
    public void longestIncreasingPath3() throws Exception {
        Solution solution = new Solution();
        int[][] matrix = {
                {3, 2, 1}
        };
        Assert.assertEquals(3, solution.longestIncreasingPath(matrix));
    }
}