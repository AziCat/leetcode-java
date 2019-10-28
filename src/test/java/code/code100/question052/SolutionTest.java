package code.code100.question052;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void totalNQueens() {
        Assert.assertEquals(0, solution.totalNQueens(0));
    }
    @Test
    public void totalNQueens1() {
        Assert.assertEquals(1, solution.totalNQueens(1));
    }
    @Test
    public void totalNQueens2() {
        Assert.assertEquals(0, solution.totalNQueens(2));
    }
    @Test
    public void totalNQueens3() {
        Assert.assertEquals(0, solution.totalNQueens(3));
    }
    @Test
    public void totalNQueens4() {
        Assert.assertEquals(2, solution.totalNQueens(4));
    }
}