package code.code50.question009;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/12
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else if (x == 10 || x % 10 == 0) {
            return false;
        } else {
            int temp = 0;
            //反转一半比较即可
            while (x > temp) {
                temp = temp * 10 + x % 10;
                x /= 10;
            }
            return x == temp || x == temp / 10;
        }
    }

}
