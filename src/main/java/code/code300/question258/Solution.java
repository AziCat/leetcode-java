package code.code300.question258;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/18
 */
public class Solution {
    /**
     * 找规律
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num <= 0) {
            return num;
        }
        int ans = num % 9;
        return ans == 0 ? 9 : ans;
    }

    public static void main(String[] args) {
        System.out.println(18 % 9);
        System.out.println(18 / 9);
    }

    /**
     * 递归
     *
     * @param num
     * @return
     */
    public int addDigits1(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum > 9 ? addDigits(sum) : sum;
    }

}
