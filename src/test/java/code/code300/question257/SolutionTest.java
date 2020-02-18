package code.code300.question257;

import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void binaryTreePaths() throws Exception {
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 3,4, null, 5, 6, null, null, null, null, 7, 8, null, null, 9});
        Solution solution = new Solution();
        List<String> ans = solution.binaryTreePaths(root);
        System.out.println(ans.toString());
    }

}