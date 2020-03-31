package code.code350.question331;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isValidSerialization() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    @Test
    public void isValidSerialization1() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isValidSerialization("9,1,#,#,#"));
    }

    @Test
    public void isValidSerialization12() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isValidSerialization("1,#"));
    }

    @Test
    public void isValidSerialization122() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isValidSerialization("9,#,#,1"));
    }
}