package code.code100.question074;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void searchMatrix() {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
                {51, 62, 63, 70}
        };
        Assert.assertTrue(solution.searchMatrix(matrix, 70));
    }

    @Test
    public void searchMatrix1() {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
                {51, 62, 63, 70}
        };
        Assert.assertFalse(solution.searchMatrix(matrix, 71));
    }
}