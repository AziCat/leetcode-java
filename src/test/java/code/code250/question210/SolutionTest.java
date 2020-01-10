package code.code250.question210;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findOrder() throws Exception {
        int[][] prerequisites = {
                {4, 1},
                {1, 0},
                {0, 3},
                {2, 0}
        };
        Solution solution = new Solution();
        Assert.assertEquals("[3, 0, 2, 1, 4]", Arrays.toString(solution.findOrder(5, prerequisites)));
    }

    @Test
    public void findOrder2() throws Exception {
        int[][] prerequisites = {

        };
        Solution solution = new Solution();
        Assert.assertEquals("[0]", Arrays.toString(solution.findOrder(1, prerequisites)));
    }

    @Test
    public void findOrder23() throws Exception {
        int[][] prerequisites = {
                {0, 1},
                {1, 0},
        };
        Solution solution = new Solution();
        Assert.assertEquals("[]", Arrays.toString(solution.findOrder(2, prerequisites)));
    }

    @Test
    public void findOrder234() throws Exception {
        int[][] prerequisites = {
                {5, 2},
                {4, 2},
                {3, 2},
                {2, 0},
                {0, 1},
                {1, 3},
        };
        Solution solution = new Solution();
        Assert.assertEquals("[]", Arrays.toString(solution.findOrder(6, prerequisites)));
    }

    @Test
    public void findOrder2345() throws Exception {
        int[][] prerequisites = {
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        };
        Solution solution = new Solution();
        Assert.assertEquals("[0, 2, 1, 3]", Arrays.toString(solution.findOrder(4, prerequisites)));
    }

    @Test
    public void findOrder23456() throws Exception {
        int[][] prerequisites = {
                {1, 0}
        };
        Solution solution = new Solution();
        Assert.assertEquals("[2, 0, 1]", Arrays.toString(solution.findOrder(3, prerequisites)));
    }

}