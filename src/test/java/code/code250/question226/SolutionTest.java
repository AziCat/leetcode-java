package code.code250.question226;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void invertTree() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{4, 2, 7, 1, 3, null, 9});
        TreeNode invertRoot = solution.invertTree(root);
        System.out.println(invertRoot);
    }

}