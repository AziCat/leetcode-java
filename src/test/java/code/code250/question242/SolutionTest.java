package code.code250.question242;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isAnagram() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void isAnagram1() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isAnagram("rat", "car"));
    }

}