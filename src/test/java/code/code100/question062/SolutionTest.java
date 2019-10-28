package code.code100.question062;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {


    @Test
    public void uniquePaths() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.uniquePaths(1, 1));
    }

    @Test
    public void uniquePaths1() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.uniquePaths(2, 2));
    }

    @Test
    public void uniquePaths12() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.uniquePaths(3, 2));
    }

    @Test
    public void uniquePaths122() {
        Solution solution = new Solution();
        Assert.assertEquals(28, solution.uniquePaths(7, 3));
    }

    @Test
    public void uniquePaths12222() {
        Solution solution = new Solution();
        Assert.assertEquals(6, solution.uniquePaths(3, 3));
    }

    @Test
    public void uniquePaths1222() {
        Solution solution = new Solution();
        System.out.println(Integer.MAX_VALUE);
        Assert.assertEquals(28, solution.uniquePaths(50, 50));
    }
}