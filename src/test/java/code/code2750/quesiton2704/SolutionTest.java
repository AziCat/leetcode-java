package code.code2750.quesiton2704;


import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int ans = solution.maxValue(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        });
        Assert.assertEquals(12, ans);
    }
}