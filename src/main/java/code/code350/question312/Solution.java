package code.code350.question312;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * 说明:
 * <p>
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 * <p>
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/3/4
 */
public class Solution {
    /**
     * 动态规划dp[i][j]表示不戳破i与j位置的气球时的最大分数，i+1<j
     * 在i与j位置中间找到k使得dp[i][j]最大，此时有dp[i][j] = dp[i][k]+dp[k][j]+nums[i]*nums[j]*nums[k]
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] nums2 = new int[nums.length + 2];
        nums2[0] = 1;
        nums2[nums2.length - 1] = 1;
        System.arraycopy(nums, 0, nums2, 1, nums.length);
        //自底向上
        for (int i = nums2.length - 3; i >= 0; i--) {
            for (int j = i + 2; j <= nums2.length - 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nums2[i] * nums2[j] * nums2[k]);
                }
            }
        }
        return dp[0][nums.length + 1];
    }
}
