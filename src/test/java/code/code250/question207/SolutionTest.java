package code.code250.question207;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void canFinish() throws Exception {
        int[][] prerequisites = {
                {4, 1},
                {1, 0},
                {0, 3},
                {2, 0}
        };
        Solution solution = new Solution();
        Assert.assertTrue(solution.canFinish(5, prerequisites));
    }
    @Test
    public void canFinish22() throws Exception {
        int[][] prerequisites = {

        };
        Solution solution = new Solution();
        Assert.assertTrue(solution.canFinish(1, prerequisites));
    }

    @Test
    public void canFinish1() throws Exception {
        int[][] prerequisites = {
                {0, 1},
                {1, 0},
        };
        Solution solution = new Solution();
        Assert.assertFalse(solution.canFinish(2, prerequisites));
    }

    @Test
    public void canFinish122() throws Exception {
        int[][] prerequisites = {
                {0, 1},
                {1, 0},
                {1, 2},
        };
        Solution solution = new Solution();
        Assert.assertFalse(solution.canFinish(3, prerequisites));
    }

    @Test
    public void canFinish21() throws Exception {
        int[][] prerequisites = {
                {5, 2},
                {4, 2},
                {3, 2},
                {2, 0},
                {0, 1},
                {1, 3},
        };
        Solution solution = new Solution();
        Assert.assertFalse(solution.canFinish(6, prerequisites));
    }
}