package code.code200.question160;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void getIntersectionNode() throws Exception {
        ListNode common = ListNode.build("1->2");

        ListNode headA = ListNode.build("4->3->2");
        headA.next.next.next = common;

        ListNode headB = ListNode.build("1->2");
        headB.next.next = common;

        Solution solution = new Solution();
        Assert.assertEquals(common, solution.getIntersectionNode(headA, headB));
    }

}