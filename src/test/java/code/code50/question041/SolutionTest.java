package code.code50.question041;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution s = new Solution();

    @Test
    public void firstMissingPositive() {
        int[] nums = {3, 4, -1, 1};
        assertEquals(2, s.firstMissingPositive(nums));
    }

    @Test
    public void firstMissingPositive1() {
        int[] nums = {3, 4, 2, 1};
        assertEquals(5, s.firstMissingPositive(nums));
    }

    @Test
    public void firstMissingPositive11() {
        int[] nums = {7, 8, 9, 11, 12};
        assertEquals(1, s.firstMissingPositive(nums));
    }

    @Test
    public void firstMissingPositive111() {
        int[] nums = {1, 2, 0};
        assertEquals(3, s.firstMissingPositive(nums));
    }

    @Test
    public void firstMissingPositive1111() {
        int[] nums = {5, 3, 4};
        assertEquals(1, s.firstMissingPositive(nums));
    }

    @Test
    public void firstMissingPositive11111() {
        int[] nums = {1, 4};
        assertEquals(2, s.firstMissingPositive(nums));
    }
}