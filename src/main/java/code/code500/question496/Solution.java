package code.code500.question496;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * <p>
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/10/26
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        LinkedList<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> ansMap = new HashMap<>();

        //num2逆序
        for (int i = m - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peekLast()) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                ansMap.put(nums2[i], -1);
                stack.addLast(nums2[i]);
            } else {
                ansMap.put(nums2[i], stack.peekLast());
                stack.addLast(nums2[i]);
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = ansMap.get(nums1[i]);
        }
        return ans;
    }
}
