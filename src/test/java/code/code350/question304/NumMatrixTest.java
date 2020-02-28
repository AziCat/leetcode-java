package code.code350.question304;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumMatrixTest {
    @Test
    public void test() throws Exception {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}

        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        Assert.assertEquals(3, numMatrix.sumRegion(0, 0, 0, 0));
        Assert.assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
        Assert.assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2));
        Assert.assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4));
    }

}