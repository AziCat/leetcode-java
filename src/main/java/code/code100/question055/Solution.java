package code.code100.question055;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 链接：https://leetcode-cn.com/problems/jump-game
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/10
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int distance;
        for (int i = 0; i < nums.length; i = getMaxIndex(i, nums)) {
            distance = i + 1;
            if (distance >= nums.length) {
                return true;
            }
            if (nums[i] == 0) {
                return false;
            }

        }
        return true;
    }

    private int getMaxIndex(int st, int[] nums) {
        int max = 0;
        int maxIndex = st;
        for (int i = st + 1; i < st + nums[st] + 1 && i < nums.length; i++) {
            int temp = nums[i];
            if (temp + i >= max) {
                max = temp + i;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
