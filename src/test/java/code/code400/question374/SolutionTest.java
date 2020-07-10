package code.code400.question374;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void guessNumber() {
        Solution solution = new Solution(6);
        Assert.assertEquals(6, solution.guessNumber(10));
    }
}