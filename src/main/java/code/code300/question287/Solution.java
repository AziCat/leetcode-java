package code.code300.question287;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/20
 */
public class Solution {
    /**
     * 把数组当成链表,节点指向的值为nums[当前节点值]
     * 例如数组[2,3,1,4,5]可以表示为链表 0->2->1->3->4->5
     * 因为数组中只有一个重复数字，则链表有环，参照question142使用3指针找第一个入环的节点
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int ans = 0, slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (ans != slow) {
            ans = nums[ans];
            slow = nums[slow];
        }
        return ans;
    }
}
