package code.code100.question084;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void largestRectangleArea() {
        Solution solution = new Solution();
        int[] heights = {2, 3, 1, 2, 3, 4, 1};
        int ans = solution.largestRectangleArea(heights);
        System.out.println(ans);
    }
}