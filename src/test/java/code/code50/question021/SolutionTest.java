package code.code50.question021;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void mergeTwoLists() {
        ListNode l1 = ListNode.build("1->2->4");
        ListNode l2 = ListNode.build("1->3->4");
        Assert.assertEquals("1->1->2->3->4->4", solution.mergeTwoLists(l1, l2).toString());
    }
    @Test
    public void mergeTwoLists1() {
        ListNode l1 = ListNode.build("1->2->4");
        ListNode l2 = ListNode.build("3->5->6->6");
        Assert.assertEquals("1->2->3->4->5->6->6", solution.mergeTwoLists(l1, l2).toString());
    }
    @Test
    public void mergeTwoLists2() {
        ListNode l1 = ListNode.build("3->5->6");
        ListNode l2 = ListNode.build("1->2->4->7");
        Assert.assertEquals("1->2->3->4->5->6->7", solution.mergeTwoLists(l1, l2).toString());
    }
}