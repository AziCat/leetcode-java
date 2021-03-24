package code.code500.question456;

import java.util.Stack;

/**
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * <p>
 * 注意：n 的值小于15000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @version 1.0
 * @since 2021/3/24 10:13
 */
public class Solution {
    /**
     * 单调栈算法-132里面，2的值越大，越容易找到1的值
     * 创建一个栈用于存放3值的候选，从右向左遍历
     * 当nums[k]>max2时，则nums[k]可作为3值，比较nums[k]与栈顶的候选3值
     * loop:如果nums[k]比栈顶大，则弹出栈顶，更新max2为Max(max2,栈顶)，如果nums[k]小于栈顶，把nums[k]放入栈，结束loop
     * 当nums[k]<max2，则nums[k]可以作为1值，返回true
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int max2 = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max2) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                max2 = stack.pop();
            }
            if (nums[i] > max2) {
                stack.push(nums[i]);
            }

        }
        return false;
    }
}
