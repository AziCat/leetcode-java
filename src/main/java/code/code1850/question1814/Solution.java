package code.code1850.question1814;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * <p>
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10的9次方 + 7 取余 后返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-nice-pairs-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/1/17
 */
public class Solution {
    /**
     * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])等价于
     * nums[i] - rev(nums[i]) = nums[j] - rev(nums[j])
     *
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = num - rev(num);
            int temp = map.getOrDefault(key, 0);
            ans = (ans + temp) % MOD;
            map.put(key, temp + 1);
        }
        return ans;
    }

    private int rev(int num) {
        int j = 0;
        int temp = num;
        while (temp > 0) {
            j = j * 10 + temp % 10;
            temp /= 10;
        }
        return j;
    }
}
