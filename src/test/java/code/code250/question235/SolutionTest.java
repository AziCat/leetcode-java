package code.code250.question235;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void lowestCommonAncestor() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        Assert.assertEquals(4, solution.lowestCommonAncestor(root, root.left.right.left, root.left.right.right).val);
    }

}