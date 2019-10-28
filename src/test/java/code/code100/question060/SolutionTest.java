package code.code100.question060;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getPermutation() {
        Solution solution = new Solution();
        Assert.assertEquals("2314", solution.getPermutation(4, 9));
    }

    @Test
    public void getPermutation1() {
        Solution solution = new Solution();
        Assert.assertEquals("123", solution.getPermutation(3, 1));
    }

    @Test
    public void getPermutation21() {
        Solution solution = new Solution();
        Assert.assertEquals("213", solution.getPermutation(3, 3));
    }

    @Test
    public void getPermutation22() {
        Solution solution = new Solution();
        Assert.assertEquals("4321", solution.getPermutation(4, 24));
    }
}