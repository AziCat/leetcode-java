package code.code600.question572;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isSubtree() {
        TreeNode s = TreeNode.build(new Integer[]{2, 2, 2, null, null, 2, 1});
        TreeNode t = TreeNode.build(new Integer[]{2, 2, 2});
        Solution solution = new Solution();
        Assert.assertFalse(solution.isSubtree(s, t));
    }

    @Test
    public void isSubtree1() {
        TreeNode s = TreeNode.build(new Integer[]{2, 2, 2, null, null, 2, 2});
        TreeNode t = TreeNode.build(new Integer[]{2, 2, 2});
        Solution solution = new Solution();
        Assert.assertTrue(solution.isSubtree(s, t));
    }

    @Test
    public void isSubtree2() {
        TreeNode s = TreeNode.build(new Integer[]{3, 4, 5, 1, 2});
        TreeNode t = TreeNode.build(new Integer[]{4, 1, 2});
        Solution solution = new Solution();
        Assert.assertTrue(solution.isSubtree(s, t));
    }

    @Test
    public void isSubtree3() {
        TreeNode s = TreeNode.build(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0});
        TreeNode t = TreeNode.build(new Integer[]{4, 1, 2});
        Solution solution = new Solution();
        Assert.assertFalse(solution.isSubtree(s, t));
    }
}