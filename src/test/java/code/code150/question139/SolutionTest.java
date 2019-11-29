package code.code150.question139;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void wordBreak() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.wordBreak("leetcodeishard", Arrays.asList("leet", "leetc", "ode", "is", "hard")));
    }

    @Test
    public void wordBreak4() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.wordBreak("leetcode", Arrays.asList("leet","code")));
    }

    @Test
    public void wordBrea1k() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    public void wordBrea1k1() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

}