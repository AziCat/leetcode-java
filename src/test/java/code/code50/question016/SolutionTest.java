package code.code50.question016;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void threeSumClosest() {
        int[] nums = {-1, 2, 1, -4};
        assertEquals(2, solution.threeSumClosest(nums, 1));
    }

    @Test
    public void threeSumClosest1() {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        assertEquals(82, solution.threeSumClosest(nums, 82));
    }

    @Test
    public void threeSumClosest2() {
        int[] nums = {-1, 0, 1, 1, 55};
        assertEquals(2, solution.threeSumClosest(nums, 3));
    }

    @Test
    public void threeSumClosest3() {
        int[] nums = {-3, -2, -5, 3, -4};

        assertEquals(-2, solution.threeSumClosest(nums, -1));
    }
}