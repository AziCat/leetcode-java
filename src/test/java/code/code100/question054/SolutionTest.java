package code.code100.question054;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void spiralOrder() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        List<Integer> ans = solution.spiralOrder(matrix);
        System.out.println(ans.toString());
    }
}