package code.code400.question382;

import java.util.Random;

/**
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 * <p>
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-random-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/15
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private final ListNode node;
    private final Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.node = head;
        this.random = new Random();
    }

    /**
     * 畜水池抽样算法
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode temp = node;
        int res = temp.val;
        int i=2;
        temp = temp.next;
        while (null != temp) {
            if (random.nextInt(i) == 0) {
                res = temp.val;
            }
            i++;
            temp = temp.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Solution solution = new Solution(head);
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }
}
