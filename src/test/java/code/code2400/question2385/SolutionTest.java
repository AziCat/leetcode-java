package code.code2400.question2385;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int result = solution.amountOfTime(TreeNode.build(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2}), 3);
        assertEquals(4, result);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int result = solution.amountOfTime(TreeNode.build(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2}), 6);
        assertEquals(5, result);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int result = solution.amountOfTime(TreeNode.build(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2}), 1);
        assertEquals(3, result);
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        int result = solution.amountOfTime(TreeNode.build(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2}), 4);
        assertEquals(4, result);
    }

}