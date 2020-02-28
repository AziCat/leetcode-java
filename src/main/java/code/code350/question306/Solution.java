package code.code350.question306;

/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * <p>
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * <p>
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * <p>
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 * <p>
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/28
 */
public class Solution {
    /**
     * 开头的两个数选择就可以判断能否进行累加，且两个数的长度不能超过字符串的一半
     *
     * @param num
     * @return
     */
    public boolean isAdditiveNumber(String num) {
        int mid = num.length() / 2;
        for (int e1 = 1; e1 <= mid; e1++) {
            if (e1 > 1 && num.charAt(0) == '0') {
                //不能为0开头
                break;
            }
            for (int e2 = e1 + 1; (e2 - e1) <= mid; e2++) {
                if (e2 - e1 > 1 && num.charAt(e1) == '0') {
                    //不能为0开头
                    break;
                }
                long sum = Long.parseLong(num.substring(0, e1)) + Long.parseLong(num.substring(e1, e2));
                if (check(e1, e2, sum, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int e1, int e2, long sum, String num) {
        String sumStr = String.valueOf(sum);
        //比较剩下的长度
        if (num.length() - e2 < sumStr.length()) {
            return false;
        }
        long num1 = Long.parseLong(num.substring(e1, e2));
        e1 = e2;
        for (int i = 0; i < sumStr.length(); i++, e2++) {
            if (sumStr.charAt(i) != num.charAt(e2)) {
                return false;
            }
        }
        return e2 == num.length() || check(e1, e2, num1 + sum, num);
    }
}
