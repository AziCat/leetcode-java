package code.code350.question344;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void reverseString() throws Exception {
        Solution solution = new Solution();
        char[] s = {'a', 'b', 'c'};
        solution.reverseString(s);
        Assert.assertEquals("[c, b, a]", Arrays.toString(s));
    }

}