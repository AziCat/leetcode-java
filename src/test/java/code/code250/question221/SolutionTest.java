package code.code250.question221;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maximalSquare() throws Exception {
        Solution solution = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        int ans = solution.maximalSquare(matrix);
        Assert.assertEquals(4, ans);
    }

    @Test
    public void maximalSquare1() throws Exception {
        Solution solution = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        int ans = solution.maximalSquare(matrix);
        Assert.assertEquals(9, ans);
    }

    @Test
    public void maximalSquare2() throws Exception {
        Solution solution = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
        };
        int ans = solution.maximalSquare(matrix);
        Assert.assertEquals(4, ans);
    }

    @Test
    public void maximalSquare4() throws Exception {
        Solution solution = new Solution();
        char[][] matrix = {
                {'0', '1'},
        };
        int ans = solution.maximalSquare(matrix);
        Assert.assertEquals(1, ans);
    }

    @Test
    public void maximalSquare5() throws Exception {
        Solution solution = new Solution();
        char[][] matrix = {
                {'0', '1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1'},
                {'1', '0', '1', '1', '0', '1', '0', '0', '1', '1', '1', '0', '0', '0', '1'},
                {'0', '1', '0', '1', '1', '1', '0', '1', '0', '1', '1', '0', '0', '1', '1'},
                {'1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'},
                {'0', '1', '1', '1', '0', '1', '0', '0', '0', '0', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '0', '1', '0', '1', '1', '1', '0', '0', '1', '1'},
                {'0', '1', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '0', '0', '0', '1', '1', '1', '0', '1', '0', '0', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1'},
                {'1', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '1'}
        };
        int ans = solution.maximalSquare(matrix);
        Assert.assertEquals(9, ans);
    }
}