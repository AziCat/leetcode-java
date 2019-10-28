package code.code100.question060;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/12
 */
public class Solution {
    public String getPermutation(int n, int k) {

        int max = 1;
        for (int i = 1; i <= n; i++) {
            max *= i;
        }
        int[] range = new int[n + 1];
        char[] ans = new char[n];
        buildRange(range, n, max);
        putNumber(ans, range, k, 0, n, max);
        return new String(ans);
    }

    private void putNumber(char[] ans, int[] range, int k, int index, int n, int max) {
        for (int i = 1; i < range.length; i++) {
            if (range[i] >= k) {
                ans[index] = (char) (i + 48);
                range[i] = -1;
                while (i > 0 && range[i - 1] == -1) {
                    i--;
                }
                k -= range[i - 1];
                max /= n;
                n--;
                if (n != 0) {
                    buildRange(range, n, max);
                    putNumber(ans, range, k, index + 1, n, max);
                    break;
                }
            }
        }
    }

    private void buildRange(int[] range, int n, int max) {
        int count = max / n;
        int num = 0;
        for (int i = 1; i < range.length; i++) {
            if (range[i] != -1) {
                num += count;
                range[i] = num;
            }
        }
    }
}
