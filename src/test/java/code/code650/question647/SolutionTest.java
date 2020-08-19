package code.code650.question647;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void countSubstrings() {
        Solution solution = new Solution();
        Assert.assertEquals(6,solution.countSubstrings("aaa"));
    }
}