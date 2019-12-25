package code.code200.question169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/25
 */
public class Solution {
    /**
     * 摩尔投票法
     * 不同的两个数之间相互消耗，因为定义的众数大于n/2，所以消耗完最后剩下的肯定是众数
     * 1ms
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int counter = 1;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (counter == 0) {
                counter = 1;
                ans = nums[i];
            } else {
                counter = ans == nums[i] ? counter + 1 : counter - 1;
            }
        }
        return ans;
    }

    /**
     * 哈希表
     * 22ms
     *
     * @param nums
     * @return
     */
    public int majorityElement__(int[] nums) {
        int n = nums.length;
        int target = n / 2;
        if (n == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int counter = map.getOrDefault(num, 0) + 1;
            if (counter > target) {
                return num;
            }
            map.put(num, counter);
        }
        return 0;
    }

    /**
     * 排序2
     * 2ms
     *
     * @param nums
     * @return
     */
    public int majorityElement2_(int[] nums) {
        Arrays.sort(nums);
        //因为众数在数组里超过一半，所以排序后对半分肯定包含了众数
        return nums[nums.length / 2];
    }

    /**
     * 排序1
     * 3ms
     *
     * @param nums
     * @return
     */
    public int majorityElement_(int[] nums) {
        int n = nums.length;
        int target = n / 2;
        if (n == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        //计数
        int counter = 1;
        for (int i = 1; i < n; i++) {
            counter = nums[i] == nums[i - 1] ? counter + 1 : 1;
            if (counter > target) {
                return nums[i];
            }
        }
        return 0;
    }
}
