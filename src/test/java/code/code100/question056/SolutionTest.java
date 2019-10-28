package code.code100.question056;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void merge() {
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        solution.merge(intervals);
    }

    @Test
    public void merge1() {
        int[][] intervals = {
                {1, 3}, {3, 6}, {6, 10}, {15, 18}
        };
        solution.merge(intervals);
    }

    @Test
    public void merge21() {
        int[][] intervals = {
                {2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}
        };
        int[][] ans = solution.merge(intervals);
    }

    @Test
    public void merge221() {
        int[][] intervals = {
                {1, 4}, {4, 5}
        };
        int[][] ans = solution.merge(intervals);
    }
}