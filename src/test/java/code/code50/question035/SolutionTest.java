package code.code50.question035;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void searchInsert() {
        int[] a = {1, 3, 4, 5, 7};
        assertEquals(0, solution.searchInsert(a, 1));
    }

    @Test
    public void searchInsert1() {
        int[] a = {1, 3, 4, 5, 7};
        assertEquals(0, solution.searchInsert(a, 0));
    }

    @Test
    public void searchInsert2() {
        int[] a = {1, 3, 4, 5, 7};
        assertEquals(1, solution.searchInsert(a, 2));
    }

    @Test
    public void searchInsert3() {
        int[] a = {1, 3, 4, 5, 7};
        assertEquals(2, solution.searchInsert(a, 4));
    }

    @Test
    public void searchInsert4() {
        int[] a = {1, 3, 4, 5, 7};
        assertEquals(4, solution.searchInsert(a, 6));
    }

    @Test
    public void searchInsert5() {
        int[] a = {1, 3, 4, 5, 7};
        assertEquals(5, solution.searchInsert(a, 8));
    }
}