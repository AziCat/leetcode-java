package code.code500.question463;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest extends TestCase {
    @Test
    public void testIslandPerimeter() {
        Solution solution = new Solution();
        int ans = solution.islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
        });
        Assert.assertEquals(16, ans);
    }
}