package code.code150.question142;

import common.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/11/29
 */
public class Solution {
    /**
     * 不用额外空间，三指针
     * 假设链表的4个节点，S为起点，E为结束，A为答案节点，M是快慢指针相遇的节点
     * Lsa指S到A的距离，以此类推。
     * 当快指针每次走两步，慢指针每次走一步，当在M相遇时慢指针走了Lx，快指针2Lx
     * 则有
     * Lx = Lsa + Lam
     * 2Lx = Lsa + Lam + Lme + 1 + Lam
     *
     * 推导得出
     * Lsa = Lme + 1
     * 所以ans指针从S开始走，慢指针从M开始走，当相遇时则到了A节点，返回A节点
     *
     * S...A...M...E
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode ans = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //当快慢指针相遇，ans指针与slow开始移动直到相遇
                while (ans != slow) {
                    ans = ans.next;
                    slow = slow.next;
                }
                return ans;
            }
        }
        return null;
    }
}
