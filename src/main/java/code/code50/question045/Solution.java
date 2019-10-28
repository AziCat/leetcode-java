package code.code50.question045;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/8
 */
public class Solution {
    private int[] nums;
    private int ans;
    private int step = 0;

    /**
     * 一开始使用回溯，因为没有限制条件会导致超时，然后改成使用贪心算法
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        this.nums = nums;
        this.ans = nums.length;
        if (nums.length <= 1) {
            return 0;
        }
        if (nums[0] + 1 >= nums.length) {
            return 1;
        }
        startJump(0);
        return ans;
    }

    private void startJump(int startIndex) {
        int distance = 0;
        int index = 0;
        for (int i = startIndex + 1; i < nums.length && i <= startIndex + nums[startIndex]; i++) {
            if (nums[i] + (i - startIndex) > distance) {
                distance = nums[i] + (i - startIndex);
                index = i;
            }
        }
        step++;
        if (index + nums[index] >= nums.length - 1) {
            ans = step + 1;
        } else {
            startJump(index);
        }
    }

}
