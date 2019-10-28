package code.code50.question048;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void rotate() {
        int[][] matrix = {
                {1, 2, 3},
                {3, 4, 5},
                {6, 7, 8}
        };
        solution.rotate(matrix);
        for (int[] aMatrix : matrix) {
            System.out.println(Arrays.toString(aMatrix));
        }
    }
}