package code.code150.question143;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void reorderList() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->3");
        solution.reorderList(head);
        Assert.assertEquals("1->3->2", head.toString());
    }

    @Test
    public void reorderList1() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->3->4");
        solution.reorderList(head);
        Assert.assertEquals("1->4->2->3", head.toString());
    }
}