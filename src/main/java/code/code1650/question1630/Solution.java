package code.code1650.question1630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 等差数列 。更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 i ， s[i+1] - s[i] == s[1] - s[0] 都成立。
 * <p>
 * 给你一个由 n 个整数组成的数组 nums，和两个由 m 个整数组成的数组 l 和 r，后两个数组表示 m 组范围查询，其中第 i 个查询对应范围 [l[i], r[i]] 。所有数组的下标都是 从 0 开始 的。
 * <p>
 * 返回 boolean 元素构成的答案列表 answer 。如果子数组 nums[l[i]], nums[l[i]+1], ... , nums[r[i]] 可以 重新排列 形成 等差数列 ，answer[i] 的值就是 true；否则answer[i] 的值就是 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/arithmetic-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/3/23
 */
public class Solution {
    /**
     * n == nums.length
     * m == l.length
     * m == r.length
     * 2 <= n <= 500
     * 1 <= m <= 500
     * 0 <= l[i] < r[i] < n
     * -105 <= nums[i] <= 105
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/arithmetic-subarrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
            int[] subArray = new int[r[i] - l[i] + 1];
            System.arraycopy(nums, l[i], subArray, 0, subArray.length);
            Arrays.sort(subArray);
            int sub = subArray[1] - subArray[0];
            boolean isResult = true;
            for (int j = 1; j < subArray.length; j++) {
                if (subArray[j] - subArray[j - 1] != sub) {
                    isResult = false;
                    break;
                }
            }
            ans.add(isResult);
        }
        return ans;
    }
}
