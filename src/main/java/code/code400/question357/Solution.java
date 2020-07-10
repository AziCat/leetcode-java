package code.code400.question357;

/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * <p>
 * 示例:
 * <p>
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/6/28
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 0;
        while (n > 0) {
            ans += helper(n);
            n--;
        }
        return ans;
    }

    private int helper(int n) {
        if (n == 1) {
            return 10;
        }
        int ans = 9;
        int seed = 1;
        while (n > 1) {
            ans *= (10 - seed);
            n--;
            seed++;
        }
        return ans;
    }
}
