package code.code150.question141;

import common.ListNode;

/**
 * @author yan
 * @version 1.0
 * @date 2020/10/9
 */
public class SolutionEveryday {
    /**
     * 使用快慢双指针，相遇则说明有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            if (fast != null && fast == slow) {
                return true;
            }
        }
        return false;
    }
}
