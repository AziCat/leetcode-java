package code.code1350.question1329;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] result = solution.diagonalSort(new int[][]{
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        });
        assertEquals("[1, 1, 1, 1]", Arrays.toString(result[0]));
        assertEquals("[1, 2, 2, 2]", Arrays.toString(result[1]));
        assertEquals("[1, 2, 3, 3]", Arrays.toString(result[2]));
    }
}