package code.code50.question033;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void search() {
        assertEquals(0, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
    }

    @Test
    public void search1() {
        assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    public void search2() {
        assertEquals(6, solution.search(new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5}, 3));
    }

    @Test
    public void search3() {
        /*int a = Arrays.binarySearch(new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5}, 0, 2, 8);
        System.out.println(a);*/
        assertEquals(2, solution.search(new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5}, 8));
    }

    @Test
    public void search4() {
        assertEquals(4, solution.search(new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5}, 1));
    }

    @Test
    public void search5() {
        assertEquals(-1, solution.search(new int[]{}, 1));
    }

    @Test
    public void search6() {
        assertEquals(0, solution.search(new int[]{1}, 1));
    }

    @Test
    public void search7() {
        assertEquals(1, solution.search(new int[]{2, 1}, 1));
    }

    @Test
    public void search8() {
        assertEquals(-1, solution.search(new int[]{1}, 2));
    }

    @Test
    public void search9() {
        assertEquals(2, solution.search(new int[]{3, 1, 2}, 2));
    }

    @Test
    public void search10() {
        assertEquals(0, solution.search(new int[]{3, 1, 2}, 3));
    }

    @Test
    public void search11() {
        assertEquals(1, solution.search(new int[]{3, 1, 2}, 1));
    }

    @Test
    public void search12() {
        assertEquals(-1, solution.search(new int[]{3, 1, 2}, 6));
    }

    @Test
    public void search13() {
        assertEquals(-1, solution.search(new int[]{3, 1, 2}, 0));
    }

    @Test
    public void search14() {
        assertEquals(1, solution.search(new int[]{5, 1, 2, 4}, 1));
    }

    @Test
    public void search15() {
        assertEquals(2, solution.search(new int[]{5, 1, 2, 4}, 2));
    }

    @Test
    public void search16() {
        assertEquals(5, solution.search(new int[]{3, 4, 5, 6, 1, 2}, 2));
    }
}