package code.code1700.question1669;

import common.ListNode;
import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testMergeInBetween() {
        ListNode list1 = ListNode.build("0->1->2->3->4->5");
        ListNode list2 = ListNode.build("1000->1001->1002");

        Solution solution = new Solution();
        ListNode ans = solution.mergeInBetween(list1, 3, 4, list2);
        System.out.println(ans);
    }
}