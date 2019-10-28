package code.code50.question029;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * <p>
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/19
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(4 << 4);
        System.out.println(2 << 3);
        System.out.println(55 >> 4);
        System.out.println(16 << 1);
    }

    /**
     * 1 ms	33.6 MB
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        long x = dividend;
        long y = divisor;
        boolean isResultGreaterThanZero = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        x = Math.abs(x);
        y = Math.abs(y);
        int ans = 0;
        while (x >= y) {
            long temp = y;
            int count = 1;
            while (x > temp + temp) {
                temp += temp;
                count += count;
            }
            ans = ans + count;
            x -= temp;
        }
        return isResultGreaterThanZero ? ans : -ans;

    }

    /**
     * 时间快了一倍，但还是很慢
     * <p>
     * 715 ms	33.8 MB
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide__(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return 0 - dividend;
        }
        boolean isResultGreaterThanZero = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        int n = 0;
        long longDividend = dividend;
        long longDivisor = divisor;
        if (dividend < 0) {
            longDividend = 0L - dividend;
        }
        if (divisor < 0) {
            longDivisor = 0L - divisor;
        }
        long oldLongDivisor = longDivisor;
        while (longDividend > longDivisor) {
            //除数乘2的n次方直到比被除数大
            longDivisor = longDivisor << 1;
            n++;
        }
        int maxCount = 1 << n;
        while (longDivisor > longDividend) {
            longDivisor -= oldLongDivisor;
            maxCount--;
        }

        return (isResultGreaterThanZero ? maxCount : 0 - maxCount);
    }

    /**
     * 时间太长
     * <p>
     * 1533 ms	33.9 MB
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide_(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return 0 - dividend;
        }
        boolean isResultGreaterThanZero = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        long longDividend = dividend;
        long longDivisor = divisor;
        if (dividend < 0) {
            longDividend = 0L - dividend;
        }
        if (divisor < 0) {
            longDivisor = 0L - divisor;
        }

        long result = 0L;
        while (longDividend >= longDivisor) {
            longDividend -= longDivisor;
            result++;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) (isResultGreaterThanZero ? result : 0 - result);
    }
}
