package code.code150.question108;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void sortedArrayToBST() throws Exception {
        Solution solution = new Solution();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);
        List<Integer> ans = new ArrayList<>();
        TreeNode.toList(Collections.singletonList(root), ans);
        System.out.println(ans.toString());
    }

}