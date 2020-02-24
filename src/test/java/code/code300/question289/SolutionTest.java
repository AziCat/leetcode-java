package code.code300.question289;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void gameOfLife() throws Exception {
        Solution solution = new Solution();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        solution.gameOfLife(board);
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }

}