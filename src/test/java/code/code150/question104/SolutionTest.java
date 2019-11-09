package code.code150.question104;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxDepth() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7});
        Assert.assertEquals(3, solution.maxDepth(root));
    }

}