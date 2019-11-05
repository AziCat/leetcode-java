package code.code50.question025;

import common.ListNode;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void reverseKGroup() {
        System.out.println(solution.reverseKGroup(ListNode.build("1->2->3->4->5"), 3));
    }
}