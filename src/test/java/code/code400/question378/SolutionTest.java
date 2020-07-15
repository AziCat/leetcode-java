package code.code400.question378;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void kthSmallest() {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 5, 8},
                {1, 5, 8},
                {1, 5, 8},
        };
        Assert.assertEquals(1, solution.kthSmallest(matrix, 3));
    }

    @Test
    public void kthSmallest1() {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 5, 8},
                {1, 5, 8},
                {1, 5, 8},
        };
        Assert.assertEquals(5, solution.kthSmallest(matrix, 5));
    }

    @Test
    public void kthSmallest2() {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 5, 8},
                {2, 7, 9},
                {3, 8, 10},
        };
        Assert.assertEquals(5, solution.kthSmallest(matrix, 4));
    }
}