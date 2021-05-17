package code.code1350.question1310;

/**
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yjh
 * @since 2021/5/12
 */
public class Solution {
    /**
     * 前缀异或
     * 异或运算满足
     * a ^ a = 0
     * 0 ^ a = a
     * 推导得出
     * [0,i+1] = arr[0]^arr[1]^...^a[i-1]^a[i]^a[i+1]
     * [0,i-1] = arr[0]^arr[1]^...^a[i-1]
     * [i,i+1] = [0,i-1]^[0,i+1]
     * Li =0：[Li,Lr] = [0,Lr]
     * Li!=0：[Li,Lr] = [0,Li-1]^[0,Lr]
     *
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] preXor = new int[arr.length];
        int[] ans = new int[queries.length];
        //前缀异或
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                preXor[i] = arr[i];
            }else {
                preXor[i] = preXor[i - 1] ^ arr[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int Li = queries[i][0];
            int Lr = queries[i][1];
            if (Li == 0) {
                ans[i] = preXor[Lr];
            }else {
                ans[i] = preXor[Li - 1] ^ preXor[Lr];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Boolean flag = null;

        System.out.println(!flag);
    }
}
