package code.code100.question051;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void solveNQueens() {
        List<List<String>> ans = solution.solveNQueens(5);
        for (List<String> an : ans) {
            System.out.println(an.toString());
        }
    }
}