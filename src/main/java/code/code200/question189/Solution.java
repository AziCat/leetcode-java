package code.code200.question189;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/26
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0 || nums.length < 2) {
            return;
        }
        helper(0, nums, k);
    }

    private void helper(int s, int[] nums, int k) {
        int length = nums.length - s;
        if (k * 2 > length) {
            swap(s, s + length - k, length - k, nums);
            helper(nums.length - k, nums, 2 * k - length);
        } else if (k * 2 < length) {
            swap(s, nums.length - k, k, nums);
            helper(s + k, nums, k);
        } else {
            swap(s, s + k, k, nums);
        }


    }

    private void swap(int s, int e, int size, int[] nums) {
        int counter = 0;
        while (counter < size) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e++;
            counter++;
        }
    }
}
