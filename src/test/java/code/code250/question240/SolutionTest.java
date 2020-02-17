package code.code250.question240;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void searchMatrix() throws Exception {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        Assert.assertTrue(solution.searchMatrix(matrix, 19));
    }

    @Test
    public void searchMatrix1() throws Exception {
        Solution solution = new Solution();
        int[][] matrix = {
                {1},
                {2},
                {3}
        };
        Assert.assertFalse(solution.searchMatrix(matrix, -1));
    }

}