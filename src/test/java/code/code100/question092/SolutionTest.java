package code.code100.question092;

import code.code50.question002.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void reverseBetween() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->3->4->5");
        System.out.println(solution.reverseBetween(head, 1, 4));
    }
}