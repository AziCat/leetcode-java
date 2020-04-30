package code.code1250.question1248;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/4/21
 */
public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        //用于记录奇数的位置
        List<Integer> position = new ArrayList<>();
        int head = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                //记录位置到最后
                position.add(i);
            }
        }
        int i = 0;
        while (position.size() >= k && end != nums.length - 1) {
            int p1 = position.get(i);
            int p2 = position.get(i + k - 1);
            if (position.size() > i + k) {
                end = position.get(i + k) - 1;
            } else {
                end = nums.length - 1;
            }
            ans += (p1 - head + 1) * (end - p2 + 1);
            head = p1 + 1;
            i++;
        }
        return ans;
    }
}
