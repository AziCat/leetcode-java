package code.code100.question066;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [9,9]
 * 输出: [1,0,0]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 链接：https://leetcode-cn.com/problems/plus-one
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/16
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        return add(digits.length - 1, digits);
    }

    private int[] add(int i, int[] digits) {
        if (i < 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        } else {
            if (digits[i] == 9) {
                digits[i] = 0;
                return add(i - 1, digits);
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
    }
}

