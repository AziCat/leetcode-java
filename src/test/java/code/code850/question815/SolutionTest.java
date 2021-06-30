package code.code850.question815;

import junit.framework.TestCase;
import org.junit.Test;

public class SolutionTest extends TestCase {
    @Test
    public void testNumBusesToDestination() {
        Solution solution = new Solution();
        int ans = solution.numBusesToDestination(new int[][]{
                {7, 12},
                {4, 5, 15},
                {6},
                {15, 19},
                {9, 12, 13},
        }, 15, 12);
        assertEquals(-1, ans);
    }

    @Test
    public void testNumBusesToDestination1() {
        Solution solution = new Solution();
        int ans = solution.numBusesToDestination(new int[][]{
                {1, 2, 7},
                {3, 6, 7},
        }, 1, 6);
        assertEquals(2, ans);
    }
}