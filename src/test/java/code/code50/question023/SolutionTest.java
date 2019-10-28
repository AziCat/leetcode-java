package code.code50.question023;

import code.code50.question002.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void mergeKLists() {
        ListNode[] list = new ListNode[]{
                ListNode.build("1->4->5"),
                ListNode.build("1->3->4"),
                ListNode.build("2->6")
        };
        Assert.assertEquals("1->1->2->3->4->4->5->6", solution.mergeKLists(list).toString());
    }
}