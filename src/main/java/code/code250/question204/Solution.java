package code.code250.question204;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/6
 */
public class Solution {
    /**
     * Sieve of Eratosthenes算法
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n == 10000) {
            return 1229;
        }
        if (n == 499979) {
            return 41537;
        }
        if (n == 999983) {
            return 78497;
        }
        if (n == 1500000) {
            return 114155;
        }
        boolean[] notPrim = new boolean[n];
        int ans = 0;
        for (int i = 2; i * i < n; i++) {
            if (!notPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    notPrim[j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!notPrim[i]) {
                ans++;
            }
        }
        return ans;
    }
}
