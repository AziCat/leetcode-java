package code.code450.question435;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void eraseOverlapIntervals() {
        Solution solution = new Solution();
        int ans = solution.eraseOverlapIntervals(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,3},
        });
    }
}