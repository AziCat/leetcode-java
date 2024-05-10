package code.code2150.question2105;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int i = solution.minimumRefill(new int[]{2, 2, 3, 3}, 5, 5);
        Assert.assertEquals(1, i);

        i = solution.minimumRefill(new int[]{2, 2, 3, 3}, 3, 4);
        Assert.assertEquals(2, i);

        i = solution.minimumRefill(new int[]{5}, 10, 8);
        Assert.assertEquals(0, i);

        i = solution.minimumRefill(new int[]{1, 2, 4, 4, 5}, 6, 5);
        Assert.assertEquals(2, i);

        i = solution.minimumRefill(new int[]{2, 3, 3}, 5, 5);
        Assert.assertEquals(0, i);

    }
}