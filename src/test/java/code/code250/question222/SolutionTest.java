package code.code250.question222;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void countNodes() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 3, 4, 5, 6});
        Assert.assertEquals(6, solution.countNodes(root));
    }

}