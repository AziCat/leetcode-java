package code.code900.question872;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void leafSimilar() {
        Solution solution = new Solution();
        TreeNode root1 = TreeNode.build(new Integer[]{2, 2, 2, 1, 3});
        TreeNode root2 = TreeNode.build(new Integer[]{4, 1, 1, null, null, 3, 2});
        Assert.assertTrue(solution.leafSimilar(root1, root2));
    }

    @Test
    public void leafSimilar2() {
        Solution solution = new Solution();
        TreeNode root1 = TreeNode.build(new Integer[]{1, 2});
        TreeNode root2 = TreeNode.build(new Integer[]{2, 2});
        Assert.assertTrue(solution.leafSimilar(root1, root2));
    }

    @Test
    public void leafSimilar1() {
        Solution solution = new Solution();
        TreeNode root1 = TreeNode.build(new Integer[]{2, 2, 2, 1, 3});
        TreeNode root2 = TreeNode.build(new Integer[]{4, 1, 1, null, null, 3, 2, 1});
        Assert.assertFalse(solution.leafSimilar(root1, root2));
    }
}