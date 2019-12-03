package code.code150.question148;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void sortList() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("4->2->1->3");
        Assert.assertEquals("1->2->3->4", solution.sortList(head).toString());
    }

    @Test
    public void sortList1() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("-1->5->3->4->0");
        Assert.assertEquals("-1->0->3->4->5", solution.sortList(head).toString());
    }

    @Test
    public void sortList12() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("-1->2");
        Assert.assertEquals("-1->2", solution.sortList(head).toString());
    }
}