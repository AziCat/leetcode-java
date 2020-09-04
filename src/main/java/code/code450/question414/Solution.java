package code.code450.question414;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/9/1
 */
public class Solution {
    public int thirdMax(int[] nums) {
        // 初始化第一,第二以及第三大元素
        long MIN_VALUE = Long.MIN_VALUE;
        long firstElement = MIN_VALUE, secondElement = MIN_VALUE, thirdElement = MIN_VALUE;
        // 遍历数组,获取第一,第二以及第三大元素
        for (int num : nums) {
            if (num > firstElement) {
                thirdElement = secondElement;
                secondElement = firstElement;
                firstElement = num;
            } else if (secondElement < num && num < firstElement) {
                thirdElement = secondElement;
                secondElement = num;
            } else if (thirdElement < num && num < secondElement) {
                thirdElement = num;
            }
        }
        // 若无第三大元素则返回数组中的最大值
        return thirdElement == MIN_VALUE ? (int) firstElement : (int) thirdElement;
    }
}
