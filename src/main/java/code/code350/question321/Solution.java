package code.code350.question321;

import java.util.Arrays;

/**
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 * <p>
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 * <p>
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/3/23
 */
public class Solution {
    /**
     * 从数组1找i个最大排序数组，从数组2找k-i个最大排序数组，再合并
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0; i <= k && i <= nums1.length; i++) {
            if (k - i <= nums2.length) {
                int temp[] = merge(find(nums1, i), find(nums2, k - i), k);
                ans = compare(ans, temp);
            }
        }
        return ans;
    }

    /**
     * 比较数组
     *
     * @param num1
     * @param num2
     * @return
     */
    private int[] compare(int[] num1, int[] num2) {
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] > num2[i]) {
                return num1;
            } else if (num1[i] < num2[i]) {
                return num2;
            }
        }
        return num1;
    }

    /**
     * 假设数组一最大组合为[6,5],数组二最大组合为[9,8,3],进行双指针排序,排序后为[9,8,6,5,3]
     */
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++)
            res[r] = gt(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return res;
    }

    /**
     * 比较两数组相应位置大小,相等就一直跳过,直到不相等就比较.
     */
    private boolean gt(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    /**
     * 找出数组按顺序最大的size个数
     * 利用数组模拟栈的结构，在满足size的情况下，栈顶的元素越大越好
     *
     * @param nums
     * @param size
     * @return
     */
    private int[] find(int nums[], int size) {
        if (size == 0) {
            return new int[]{};
        }
        if (nums.length == size) {
            return nums;
        }
        int[] stack = new int[size];
        stack[0] = nums[0];
        int top = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > stack[top - 1] || top < size) {
                while (top != 0 && nums[i] > stack[top - 1] && (nums.length - i + top - 1 >= size)) {
                    top--;
                }
                stack[top] = nums[i];
                top++;
            }
        }
        return stack;
    }
}
