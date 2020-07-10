package code.code400.question373;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void kSmallestPairs() {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.kSmallestPairs(new int[]{1, 7, 11},
                new int[]{2, 4, 6}, 3);
        for (List<Integer> an : ans) {
            System.out.println(an.toString());
        }
    }

    @Test
    public void kSmallestPairs1() {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.kSmallestPairs(new int[]{1, 7, 11},
                new int[]{2}, 8);
        for (List<Integer> an : ans) {
            System.out.println(an.toString());
        }
    }

    @Test
    public void kSmallestPairs12() {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.kSmallestPairs(new int[]{1, 1, 2},
                new int[]{1, 2, 3}, 8);
        for (List<Integer> an : ans) {
            System.out.println(an.toString());
        }
    }

    @Test
    public void kSmallestPairs121() {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.kSmallestPairs(new int[]{-10, -4, 0, 0, 6},
                new int[]{3, 5, 6, 7, 8, 100}, 10);
        for (List<Integer> an : ans) {
            System.out.println(an.toString());
        }
    }
}