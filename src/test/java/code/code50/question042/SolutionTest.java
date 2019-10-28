package code.code50.question042;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void trap() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertEquals(6, solution.trap(height));
    }

    @Test
    public void trap1() {
        int[] height = {0, 2, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertEquals(7, solution.trap(height));
    }

    @Test
    public void trap2() {
        int[] height = {5, 0, 0, 6};
        assertEquals(10, solution.trap(height));
    }


    @Test
    public void trap4() {
        int[] height = {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3};
        assertEquals(83, solution.trap(height));
    }

    @Test
    public void trap5() {
        int[] height = {4, 9, 4, 5, 3, 2};
        assertEquals(1, solution.trap(height));
    }
}