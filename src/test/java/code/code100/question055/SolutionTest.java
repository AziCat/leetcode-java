package code.code100.question055;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void canJump() {
        Assert.assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void canJump1() {
        Assert.assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void canJump21() {
        Assert.assertTrue(solution.canJump(new int[]{2, 0}));
    }

    @Test
    public void canJump212() {
        Assert.assertTrue(solution.canJump(new int[]{2, 0, 1, 3, 0, 0, 1}));
    }

    @Test
    public void canJump221() {
        Assert.assertTrue(solution.canJump(new int[]{2, 0, 0}));
    }

    @Test
    public void canJump2s21() {
        Assert.assertTrue(solution.canJump(new int[]{1, 1, 2, 2, 0, 1, 1}));
    }

    @Test
    public void canJump2ss21() {
        Assert.assertFalse(solution.canJump(new int[]{3, 4, 0, 1, 0, 0, 3, 0}));
    }

    @Test
    public void canJump2s2s21() {
        Assert.assertFalse(solution.canJump(new int[]{1, 1, 0, 1}));
    }
}