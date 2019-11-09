package code.code150.question107;

import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void levelOrderBottom() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 9, 20, 1, null, 15, 7, 2});
        List<List<Integer>> ans = solution.levelOrderBottom(root);
        for (List<Integer> an : ans) {
            System.out.println(an.toString());

        }
    }

}