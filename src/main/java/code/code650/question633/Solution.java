package code.code650.question633;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * @author yjh
 * @since 2021/4/28
 */
public class Solution {
    /**
     * c进行开方，a跟b必定在1~sqrt(c)之前，再使用双指针
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int right = (int) Math.ceil(Math.sqrt(c));
        int left = 0;
        while (left <= right) {
            int temp = left * left + right * right;
            if (temp == c) {
                return true;
            } else if (temp > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

}
