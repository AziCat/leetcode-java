package code.code200.question167;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/24
 */
public class Solution {
    /**
     * 双指针1 ms
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int s = 0;
        int e = numbers.length-1;
        while (s <= e) {
            int sum = numbers[s] + numbers[e];
            if (sum == target) {
                return new int[]{s + 1, e + 1};
            } else if (sum < target) {
                //值比target小，左指针右移
                s++;
            }else {
                e--;
            }
        }
        return null;
    }

    /**
     * 字典2ms
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];
            //因为数组是升序的，如果num大于numbers[i]，说明解在后面，否则在缓存中找解
            if (num > numbers[i]) {
                position.put(num, i);
            } else {
                Integer index1 = position.get(numbers[i]);
                if (null != index1) {
                    return new int[]{index1 + 1, i + 1};
                } else {
                    position.put(num, i);
                }
            }
        }
        return null;
    }
}
