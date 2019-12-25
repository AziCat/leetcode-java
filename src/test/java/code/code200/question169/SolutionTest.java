package code.code200.question169;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void majorityElement() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.majorityElement(new int[]{3, 1, 2, 2, 2, 2, 4}));
    }

}