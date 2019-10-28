package code.code50.question019;

import code.code50.question002.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void removeNthFromEnd() {
        ListNode listNode = ListNode.build("1->2->3->4->5");
        listNode = solution.removeNthFromEnd(listNode, 2);
        Assert.assertEquals("1->2->3->5", listNode.toString());
    }

    @Test
    public void removeNthFromEnd1() {
        ListNode listNode = ListNode.build("1->2->3->4->5");
        listNode = solution.removeNthFromEnd(listNode, 1);
        Assert.assertEquals("1->2->3->4", listNode.toString());
    }

    @Test
    public void removeNthFromEnd2() {
        ListNode listNode = ListNode.build("1->2->3->4->5");
        listNode = solution.removeNthFromEnd(listNode, 5);
        Assert.assertEquals("2->3->4->5", listNode.toString());
    }

    @Test
    public void removeNthFromEnd3() {
        ListNode listNode = ListNode.build("1");
        listNode = solution.removeNthFromEnd(listNode, 1);
        Assert.assertNull(listNode);
    }
}