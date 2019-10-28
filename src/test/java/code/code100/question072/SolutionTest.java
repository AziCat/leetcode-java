package code.code100.question072;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minDistance() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.minDistance("horse", "ros"));
    }

    @Test
    public void minDistance1() {
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.minDistance("execution", "intention"));
    }

    @Test
    public void minDistance2() {
        Solution solution = new Solution();
        Assert.assertEquals(9, solution.minDistance("execution", ""));
    }

    @Test
    public void minDistance3() {
        Solution solution = new Solution();
        Assert.assertEquals(9, solution.minDistance("", "execution"));
    }

    @Test
    public void minDistance4() {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.minDistance("", ""));
    }

    @Test
    public void minDistance5() {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.minDistance("a", "a"));
    }

    @Test
    public void minDistance6() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.minDistance("aaa", "a"));
    }

    @Test
    public void minDistance7() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.minDistance("sea", "eat"));
    }
}