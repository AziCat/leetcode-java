package code.code100.question100;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isSameTree() throws Exception {
        Solution solution = new Solution();
        TreeNode p = TreeNode.build(new Integer[]{1, 2, 3});
        TreeNode q = TreeNode.build(new Integer[]{1, 2, 3});
        Assert.assertTrue(solution.isSameTree(p, q));
    }

    @Test
    public void isSameTree1() throws Exception {
        Solution solution = new Solution();
        TreeNode p = TreeNode.build(new Integer[]{1, null, 2, 3});
        TreeNode q = TreeNode.build(new Integer[]{1, null, 2, 3});
        Assert.assertTrue(solution.isSameTree(p, q));
    }

    @Test
    public void isSameTree2() throws Exception {
        Solution solution = new Solution();
        TreeNode p = TreeNode.build(new Integer[]{1, null, 2, 3});
        TreeNode q = TreeNode.build(new Integer[]{1, 2, null, 3});
        Assert.assertFalse(solution.isSameTree(p, q));
    }

}