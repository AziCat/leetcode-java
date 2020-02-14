package code.code250.question236;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void lowestCommonAncestor() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        Assert.assertEquals(3, solution.lowestCommonAncestor(root, root.left, root.right).val);
    }

    @Test
    public void lowestCommonAncestor1() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        Assert.assertEquals(3, solution.lowestCommonAncestor(root, root.left, root.right.left).val);
    }

    @Test
    public void lowestCommonAncestor2() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        Assert.assertEquals(3, solution.lowestCommonAncestor(root, root.left, root.right.right).val);
    }

    @Test
    public void lowestCommonAncestor3() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        Assert.assertEquals(5, solution.lowestCommonAncestor(root, root.left, root.left.left).val);
    }
    @Test
    public void lowestCommonAncestor4() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        Assert.assertEquals(5, solution.lowestCommonAncestor(root, root.left, root.left.right).val);
    }
    @Test
    public void lowestCommonAncestor5() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        Assert.assertEquals(5, solution.lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}