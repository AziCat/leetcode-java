package code.code1150.question1129;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] ans = solution.shortestAlternatingPaths(3, new int[][]{
                {0, 1},
                {1, 2}
        }, new int[][]{});
        Assert.assertEquals("[0, 1, -1]", Arrays.toString(ans));
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] ans = solution.shortestAlternatingPaths(3, new int[][]{
                {0, 1},
        }, new int[][]{
                {2, 1}
        });
        Assert.assertEquals("[0, 1, -1]", Arrays.toString(ans));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] ans = solution.shortestAlternatingPaths(3, new int[][]{
                {1, 0},
        }, new int[][]{
                {2, 1}
        });
        Assert.assertEquals("[0, -1, -1]", Arrays.toString(ans));
    }
}