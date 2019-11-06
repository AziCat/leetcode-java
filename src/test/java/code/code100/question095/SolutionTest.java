package code.code100.question095;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void generateTrees() throws Exception {
        Solution solution = new Solution();
        List<TreeNode> ans = solution.generateTrees(3);
        Assert.assertEquals(5, ans.size());
    }

}