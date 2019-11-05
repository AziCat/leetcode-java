package code.code100.question061;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void rotateRight() {
        Solution solution = new Solution();
        Assert.assertEquals("1->2->0", solution.rotateRight(ListNode.build("0->1->2"), 5).toString());
    }

    @Test
    public void rotateRight1() {
        Solution solution = new Solution();
        Assert.assertEquals("4->5->1->2->3", solution.rotateRight(ListNode.build("1->2->3->4->5"), 2).toString());
    }

    @Test
    public void rotateRight12() {
        Solution solution = new Solution();
        Assert.assertEquals("2->3->1", solution.rotateRight(ListNode.build("1->2->3"), 2000000000).toString());
    }
}