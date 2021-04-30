package code.code500.question453;

/**
 * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [1,2,3]
 * 输出：
 * 3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/4/27
 */
public class Solution {
    /**
     * 每次可以使n-1个元素加1，反过来就是每次使1个元素-1，那么只需要找到数组里的最小值，大于最小值的元素-1直到取最小值相等
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int ans = 0;
        int min = nums[0];
        int minCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == min) {
                minCount++;
            } else if (nums[i] > min) {
                ans += nums[i] - min;
                minCount++;
            } else {
                ans += minCount * (min - nums[i]);
                min = nums[i];
                minCount++;
            }
        }
        return ans;
    }
}
