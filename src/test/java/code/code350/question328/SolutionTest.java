package code.code350.question328;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void oddEvenList() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1");
        Assert.assertEquals("1", solution.oddEvenList(head).toString());
    }

    @Test
    public void oddEvenList1() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2");
        Assert.assertEquals("1->2", solution.oddEvenList(head).toString());
    }

    @Test
    public void oddEvenList2() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->3");
        Assert.assertEquals("1->3->2", solution.oddEvenList(head).toString());
    }

    @Test
    public void oddEvenList3() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->3->4");
        Assert.assertEquals("1->3->2->4", solution.oddEvenList(head).toString());
    }

    @Test
    public void oddEvenList4() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->3->4->5");
        Assert.assertEquals("1->3->5->2->4", solution.oddEvenList(head).toString());
    }
}