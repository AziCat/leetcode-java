package code.code150.question130;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solve() throws Exception {
        Solution solution = new Solution();
        char[][] board = {
                {'X','O','X','X','O','X','X'},
                {'X','X','X','X','O','X','X'},
                {'X','O','X','O','O','X','X'},
                {'O','O','X','X','X','O','X'},
                {'X','X','O','O','X','O','O'},
                {'X','X','X','X','O','X','X'},
        };
        solution.solve(board);
        for (char[] chars : board) {
            System.out.println(new String(chars));
        }
    }

}