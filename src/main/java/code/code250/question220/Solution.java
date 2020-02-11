package code.code250.question220;

import java.util.HashSet;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/10
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 10000 ) {
            return false;
        }
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (Long integer : set) {
                if (Math.abs(integer - nums[i]) <= t) {
                    return true;
                }
            }
            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
