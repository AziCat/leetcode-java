package code.code150.question113;

import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void pathSum() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        List<List<Integer>> ans = solution.pathSum(root, 22);
        for (List<Integer> an : ans) {
            System.out.println(an.toString());
        }
    }

}