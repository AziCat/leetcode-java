package code.code250.question217;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/15
 */
public class Solution {
    /**
     * 排序
     * @param nums
     * @return
     */
    public boolean containsDuplicate_(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 1) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int num : nums) {
            if (hash.contains(num)) {
                return true;
            }
            hash.add(num);
        }
        return false;
    }
}
