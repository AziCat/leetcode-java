package code.code150.question112;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void hasPathSum() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        Assert.assertTrue(solution.hasPathSum(root, 22));
    }

}