package code.code400.question383;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void canConstruct() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.canConstruct("abc", "wherecanwebuyacar"));
    }

    @Test
    public void canConstruct1() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.canConstruct("a", "b"));
    }

    @Test
    public void canConstruct2() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.canConstruct("ab", "ac"));
    }

    @Test
    public void canConstruct3() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.canConstruct("aa", "aabc"));
    }
}