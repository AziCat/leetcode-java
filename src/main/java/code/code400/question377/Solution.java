package code.code400.question377;

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * <p>
 * 示例:
 * <p>
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * 请注意，顺序不同的序列被视作不同的组合。
 * <p>
 * 因此输出为 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/10
 */
public class Solution {
    private Integer[] cache;


    /**
     * dfs+记忆搜索
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum41(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (cache == null) {
            cache = new Integer[target + 1];
        }
        if (cache[target] != null) {
            return cache[target];
        }
        int ans = 0;
        for (int num : nums) {
            int temp = target - num;
            if (temp > 0) {
                ans += combinationSum4(nums, temp);
            } else if (temp == 0) {
                ans += 1;
            }
        }
        cache[target] = ans;
        return ans;
    }

    /**
     * 动态规则
     * dp[i]为组成i的排列组合数
     * dp[i]=dp[i-nums[0]] + dp[i-nums[1]] + ....
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0]=1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
