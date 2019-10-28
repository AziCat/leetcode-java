package code.code100.question069;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 链接：https://leetcode-cn.com/problems/sqrtx
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/21
 */
public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        return compute(0, x, x);
    }

    private int compute(int s, int e, int x) {
        if (s + 1 == e) {
            return s;
        }
        int mid = (s + e) / 2;
        long temp = 1L * mid * mid;
        if (temp == x) {
            return mid;
        } else if (temp > x || temp < 0) {
            return compute(s, mid, x);
        } else {
            return compute(mid, e, x);
        }
    }
}
