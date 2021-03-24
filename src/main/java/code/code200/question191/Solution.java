package code.code200.question191;

/**
 * @author yjh
 * @version 1.0
 * @since 2021/3/23 10:00
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

}
