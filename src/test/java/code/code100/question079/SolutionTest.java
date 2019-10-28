package code.code100.question079;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void exist() {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assert.assertTrue(solution.exist(board, "ABCCED"));
    }

    @Test
    public void exist1() {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assert.assertFalse(solution.exist(board, "ABCB"));
    }

    @Test
    public void exist2() {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assert.assertTrue(solution.exist(board, "BFCEESEC"));
    }

    @Test
    public void exist3() {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'A'}
        };
        Assert.assertTrue(solution.exist(board, "A"));
    }

    @Test
    public void exist4() {
        Solution solution = new Solution();
        char[][] board = {
                {'F', 'Y', 'C', 'E', 'N', 'R', 'D'},
                {'K', 'L', 'N', 'F', 'I', 'N', 'U'},
                {'A', 'A', 'A', 'R', 'A', 'H', 'R'},
                {'N', 'D', 'K', 'L', 'P', 'N', 'E'},
                {'A', 'L', 'A', 'N', 'S', 'A', 'P'},
                {'O', 'O', 'G', 'O', 'T', 'P', 'N'},
                {'H', 'P', 'O', 'L', 'A', 'N', 'O'},
        };
        Assert.assertTrue(solution.exist(board, "FRANCE"));
    }


    @Test
    public void exist5() {
        Solution solution = new Solution();
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        Assert.assertTrue(solution.exist(board, "AAB"));
    }
}