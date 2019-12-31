package code.code200.question200;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void numIslands() throws Exception {
        Solution solution = new Solution();
        char[][] grid = {
                {}
        };
        Assert.assertEquals(0, solution.numIslands(grid));

    }

    @Test
    public void numIslands1() throws Exception {
        Solution solution = new Solution();
        char[][] grid = {
                {'0', '0', '0', '1'}
        };
        Assert.assertEquals(1, solution.numIslands(grid));
    }

    @Test
    public void numIslands12() throws Exception {
        Solution solution = new Solution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Assert.assertEquals(1, solution.numIslands(grid));
    }

    @Test
    public void numIslands122() throws Exception {
        Solution solution = new Solution();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void numIslands1122() throws Exception {
        Solution solution = new Solution();
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        Assert.assertEquals(1, solution.numIslands(grid));
    }
}