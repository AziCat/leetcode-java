package code.code200.question174;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void calculateMinimumHP() throws Exception {
        Solution solution = new Solution();
        int[][] matrix = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        Assert.assertEquals(7, solution.calculateMinimumHP(matrix));

    }

}