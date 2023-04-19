package code.code2400.question2357;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个非负整数数组 nums 。在一步操作中，你必须：
 * <p>
 * 选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
 * nums 中的每个正整数都减去 x。
 * 返回使 nums 中所有元素都等于 0 需要的 最少 操作数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/2/24
 */
public class Solution {
    /**
     * 通过找规律，答案为不同数字的个数
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     *
     * @param nums
     * @return
     */
    public int minimumOperations(int[] nums) {
        int[] set = new int[101];
        int ans = 0;
        for (int num : nums) {
            if (num != 0 && set[num] == 0) {
                set[num] = 1;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.minimumOperations(new int[]{0,0,0});
        System.out.println(ans);
    }
}
