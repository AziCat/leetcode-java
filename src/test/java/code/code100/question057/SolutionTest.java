package code.code100.question057;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void insert() {
        Solution solution = new Solution();
        int[][] a1 = {
                {1, 3},
                {6, 9}
        };
        int[] a2 = {2, 5};
        Assert.assertEquals(2, solution.insert(a1, a2).length);
    }

    @Test
    public void insert1() {
        Solution solution = new Solution();
        int[][] a1 = {
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        };
        int[] a2 = {11, 11};
        Assert.assertEquals(6, solution.insert(a1, a2).length);
    }

    @Test
    public void insert21() {
        Solution solution = new Solution();
        int[][] a1 = {

        };
        int[] a2 = {11, 11};
        Assert.assertEquals(1, solution.insert(a1, a2).length);
    }

    @Test
    public void insert211() {
        Solution solution = new Solution();
        int[][] a1 = {
                {1, 5}
        };
        int[] a2 = {2, 3};
        Assert.assertEquals(1, solution.insert(a1, a2).length);
    }

    @Test
    public void insert2f11() {
        Solution solution = new Solution();
        int[][] a1 = {
                {1, 5}
        };
        int[] a2 = {6, 8};
        Assert.assertEquals(2, solution.insert(a1, a2).length);
    }

    @Test
    public void inserts2f11() {
        Solution solution = new Solution();
        int[][] a1 = {
                {1, 5}
        };
        int[] a2 = {0, 0};
        Assert.assertEquals(2, solution.insert(a1, a2).length);
    }
}