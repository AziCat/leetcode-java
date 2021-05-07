package code.code1750.question1720;

/**
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * <p>
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * <p>
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * <p>
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/5/6
 */
public class Solution {
    /**
     * 已知异或运算满足 A ^ A = 0,A ^ 0 = A
     * 目前encoded[i] = arr[i] ^ arr[i+1]
     * 得出encoded[i-1] = arr[i-1] ^ arr[i]
     * 再得出encode[i-1] ^ arr[i-1] = arr[i-1] ^ arr[i] ^ arr[i-1] = 0 ^ arr[i] = arr[i]
     * @param encoded
     * @param first
     * @return
     */
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = encoded[i - 1] ^ ans[i - 1];
        }
        return ans;
    }
}
