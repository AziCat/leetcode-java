package code.code1850.question1813;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest extends TestCase {
    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.areSentencesSimilar("of", "A lot of words"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.areSentencesSimilar("My name is Haley", "My Haley"));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.areSentencesSimilar("a b", "a d b"));
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.areSentencesSimilar("a", "b"));
    }

    @Test
    public void test5() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.areSentencesSimilar("A", "a A d A"));
    }

    @Test
    public void test6() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.areSentencesSimilar("A b c d e", "A b c"));
    }
}