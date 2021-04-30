package code.code500.question457;

/**
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * <p>
 * 如果 nums[i] 是正数，向前 移动 nums[i] 步
 * 如果 nums[i] 是负数，向后 移动 nums[i] 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * <p>
 * 数组中的 循环 由长度为 k 的下标序列 seq ：
 * <p>
 * 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circular-array-loop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/4/30
 */
public class Solution {
    /**
     * 双指针+记忆法
     *
     * @param nums
     * @return
     */
    public boolean circularArrayLoop(int[] nums) {
        //记忆已经走过的位置
        int[] walk = new int[nums.length];
        for (int start = 0; start < nums.length; start++) {
            if (walk[start] == 1) {
                //已经走过
                continue;
            }
            //标记为已走
            walk[start] = 1;
            //是否大于0
            boolean flag = nums[start] > 0;
            int slow = walk(nums, start);
            int fast = walk(nums, slow);
            while (slow != fast && nums[fast] > 0 == flag) {
                //快慢双指针
                slow = walk(nums, slow);
                fast = walk(nums, fast);
                if (nums[fast] > 0 != flag) {
                    break;
                }
                fast = walk(nums, fast);
                walk[slow] = 1;
            }
            if (slow == fast && nums[slow] > 0 == flag && slow != walk(nums, slow)) {
                //如果快指针与慢指针相等，方向没错且长度不为1
                return true;
            }
        }
        return false;
    }

    private int walk(int[] nums, int p) {
        int walkSize = p + nums[p] % nums.length;
        if (walkSize < 0) {
            return walkSize + nums.length;
        }
        if (walkSize >= nums.length) {
            return walkSize - nums.length;
        }
        return walkSize;
    }

}
