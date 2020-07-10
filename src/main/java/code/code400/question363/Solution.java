package code.code400.question363;

import java.util.Arrays;

/**
 * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 * <p>
 * 示例:
 * <p>
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/4/22
 */
public class Solution {
    /**
     * 前缀和+暴力
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, ans = Integer.MIN_VALUE;
        int[] rowSum = new int[rows];
        int pre = 0, tmpSum = 0;
        //固定左边界
        for (int l = 0; l < cols; l++) {
            Arrays.fill(rowSum, 0);
            //遍历右边界
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rows; i++) {
                    //最大连续子串
                    rowSum[i] += matrix[i][r];
                    if (i == 0) {
                        pre = rowSum[0];
                        tmpSum = pre;
                    } else {
                        pre = Math.max(pre + rowSum[i], rowSum[i]);
                        tmpSum = Math.max(pre, tmpSum);
                    }
                }
                if (tmpSum <= k) {
                    ans = Math.max(ans, tmpSum);
                    continue;
                }
                //如果最大值超出k，再进行暴力查找
                for (int i = 0; i < rowSum.length; i++) {
                    tmpSum = 0;
                    for (int j = i; j < rowSum.length; j++) {
                        tmpSum += rowSum[j];
                        if (tmpSum <= k) {
                            ans = Math.max(ans, tmpSum);
                        }
                    }
                }
            }
        }
        return ans;
    }

}
