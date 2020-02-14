package code.code250.question238;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/14
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        //先从左开始累乘，暂时记录在output数组中
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                output[0] = nums[0];
            } else {
                output[i] = output[i - 1] * nums[i];
            }
        }
        //再从右边开始累乘
        int pre = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                output[i] = pre;
            } else {
                output[i] = pre * output[i - 1];
                pre = i == nums.length - 1 ? nums[i] : pre * nums[i];
            }
        }
        return output;
    }
}
