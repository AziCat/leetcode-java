package code.code450.question424;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void characterReplacement() {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.characterReplacement("AABABBA", 1));
    }
}