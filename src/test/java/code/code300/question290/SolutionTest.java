package code.code300.question290;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void wordPattern() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.wordPattern("aabb", "cat cat dog dog"));
    }

    @Test
    public void wordPattern1() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.wordPattern("abba", "dog dog dog dog"));
    }
}