package code.code450.question447;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest extends TestCase {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[][] points = new int[][]{{0, 0}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int ans = solution.numberOfBoomerangs(points);
        Assert.assertEquals(20, ans);
    }
}