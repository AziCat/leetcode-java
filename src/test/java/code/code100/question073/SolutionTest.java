package code.code100.question073;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void setZeroes() {
        Solution solution = new Solution();
        int[][] matrix = {
                {3, 1, 2, 5},
                {3, 0, 1, 2},
                {1, 3, 1, 1}
        };
        solution.setZeroes(matrix);
        String ans = "[3, 0, 2, 5]\n" +
                "[0, 0, 0, 0]\n" +
                "[1, 0, 1, 1]\n";
        StringBuilder sb = new StringBuilder();
        for (int[] ints : matrix) {
            sb.append(Arrays.toString(ints)).append("\n");
        }
        Assert.assertEquals(ans, sb.toString());
    }
}