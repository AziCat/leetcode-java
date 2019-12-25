package code.code200.question168;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void convertToTitle() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("AB", solution.convertToTitle(28));
    }

}