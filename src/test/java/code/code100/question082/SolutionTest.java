package code.code100.question082;

import code.code50.question002.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void deleteDuplicates() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->2->2->3");
        ListNode ans = solution.deleteDuplicates(head);
        Assert.assertEquals("1->3", ans.toString());
    }
    @Test
    public void deleteDuplicates1() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("2->2->2->2->2");
        ListNode ans = solution.deleteDuplicates(head);
        Assert.assertNull(ans);
    }

    @Test
    public void deleteDuplicates2() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->1->2->2->2->3->4->5->5->6->7->7");
        ListNode ans = solution.deleteDuplicates(head);
        Assert.assertEquals("3->4->6", ans.toString());
    }

    @Test
    public void deleteDuplicates3() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("-2147483648->2147483647->2");
        ListNode ans = solution.deleteDuplicates(head);
        Assert.assertEquals("-2147483648->2147483647->2", ans.toString());
    }
}