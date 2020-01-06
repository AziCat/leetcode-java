package code.code250.question203;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void removeElements() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->6->3->4->5->6");
        Assert.assertEquals("1->2->3->4->5", solution.removeElements(head, 6).toString());
    }

    @Test
    public void removeElements1() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->1->1->3->4->5->6");
        Assert.assertEquals("3->4->5->6", solution.removeElements(head, 1).toString());
    }

    @Test
    public void removeElements12() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1");
        Assert.assertEquals(null, solution.removeElements(head, 1));
    }

}