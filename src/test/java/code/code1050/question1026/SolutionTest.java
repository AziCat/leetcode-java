package code.code1050.question1026;

import common.TreeNode;
import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test1() {
        Solution solution = new Solution();
        assertEquals(7, solution.maxAncestorDiff(TreeNode.build("[8,3,10,1,6,null,14,null,null,4,7,13]")));
    }

    public void test2() {
        Solution solution = new Solution();
        assertEquals(3, solution.maxAncestorDiff(TreeNode.build("[1,null,2,null,0,3]")));
    }
}