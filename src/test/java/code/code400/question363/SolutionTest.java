package code.code400.question363;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxSumSubmatrix() {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 0, 1},
                {0, -2, 3}
        };
        Assert.assertEquals(2, solution.maxSumSubmatrix(matrix, 2));
    }

    @Test
    public void maxSumSubmatrix1() {
        Solution solution = new Solution();
        int[][] matrix = {
                {4, -2, 6, -3, 1},
                {0, 4, 2, 4, 5},
                {6, -9, 6, -2, 1}
        };
        Assert.assertEquals(17, solution.maxSumSubmatrix(matrix, 19));
    }
    @Test
    public void maxSumSubmatrix12() {
        Solution solution = new Solution();
        int[][] matrix = {
                {4, -2, 6, -3, 1},
                {0, 4, 2, 4, 5},
                {6, -9, 6, -2, 1}
        };
        Assert.assertEquals(20, solution.maxSumSubmatrix(matrix, 20));
    }
}