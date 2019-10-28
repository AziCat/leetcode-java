package code.code50.question011;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void maxArea1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, solution.maxArea(height));
    }

    @Test
    public void maxArea2() {
        int[] height = {1, 1};
        assertEquals(1, solution.maxArea(height));
    }

    @Test
    public void maxArea3() {
        int[] height = {1, 3, 2, 4, 3};
        assertEquals(9, solution.maxArea(height));
    }

    @Test
    public void maxArea4() {
        int[] height = {1, 3, 2, 5, 25, 24, 5};
        assertEquals(24, solution.maxArea(height));
    }
}