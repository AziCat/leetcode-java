package code.code950.question909;

import junit.framework.TestCase;
import org.junit.Test;

public class SolutionTest extends TestCase {
    @Test
    public void testSnakesAndLadders() {
        Solution solution = new Solution();
        int ans = solution.snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1},
        });
        assertEquals(4, ans);
    }

    @Test
    public void testSnakesAndLadders1() {
        Solution solution = new Solution();
        int ans = solution.snakesAndLadders(new int[][]{
                {1, 1, -1},
                {1, 1, 1},
                {-1, 1, 1},
        });
        assertEquals(-1, ans);
    }

    @Test
    public void testSnakesAndLadders2() {
        Solution solution = new Solution();
        int ans = solution.snakesAndLadders(new int[][]{
                {-1, -1, 19, 10, -1},
                {2, -1, -1, 6, -1},
                {-1, 17, -1, 19, -1},
                {25, -1, 20, -1, -1},
                {-1, -1, -1, -1, 15},
        });
        assertEquals(2, ans);
    }
}