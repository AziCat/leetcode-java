package code.code100.question083;

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
        Assert.assertEquals("1->2->3", ans.toString());
    }

    @Test
    public void deleteDuplicates1() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->2->2->2");
        ListNode ans = solution.deleteDuplicates(head);
        Assert.assertEquals("1->2", ans.toString());
    }

    @Test
    public void deleteDuplicates2() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->1->1->1->1");
        ListNode ans = solution.deleteDuplicates(head);
        Assert.assertEquals("1", ans.toString());
    }
    @Test
    public void deleteDuplicates3() {
        Solution solution = new Solution();
        ListNode ans = solution.deleteDuplicates(null);
        Assert.assertNull(ans);
    }
}