package code.code200.question199;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void rightSideView() throws Exception {
        Solution solution = new Solution();
        List<Integer> ans = solution.rightSideView(TreeNode.build(new Integer[]{1, 2, 3, null, 5, null, 4}));
        Assert.assertEquals("[1, 3, 4]", ans.toString());
    }

    @Test
    public void rightSideView1() throws Exception {
        Solution solution = new Solution();
        List<Integer> ans = solution.rightSideView(TreeNode.build(new Integer[]{1, 2, 3, 4, null, null, 5, null, 6, null, null, 7, 8, 9, null, null, 10}));
        Assert.assertEquals("[1, 3, 5, 6, 8, 10]", ans.toString());
    }

}