package code.code250.question218;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void getSkyline() throws Exception {
        Solution solution = new Solution();
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        List<List<Integer>> ans = solution.getSkyline(buildings);
        Assert.assertEquals("[[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]]",
                ans.toString());

    }

    @Test
    public void getSkyline1() throws Exception {
        Solution solution = new Solution();
        int[][] buildings = {
                {2, 9, 10},
                {2, 3, 4},
                {9, 10, 4},
                {9, 11, 10},
                {9, 10, 12},
        };
        List<List<Integer>> ans = solution.getSkyline(buildings);
        Assert.assertEquals("[[2, 10], [9, 12], [10, 10], [11, 0]]",
                ans.toString());

    }

}