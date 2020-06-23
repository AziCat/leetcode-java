package code.code250.question221;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/10
 */
public class Solution {
    /**
     * 动态规则
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i][j])) + 1;
                    ans = Math.max(ans, dp[i + 1][j + 1]);
                }
            }
        }
        return ans * ans;
    }

    /**
     * 动态规划
     *
     * @param matrix
     * @return
     */
    public int maximalSquare__(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }

    private int ans = 0;

    /**
     * @param matrix
     * @return
     */
    public int maximalSquare1(char[][] matrix) {
        if (matrix.length == 0) {
            return ans;
        }
        //求高度矩阵
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '0') {
                        heights[i][j] = 0;
                    } else {

                        heights[i][j] = matrix[i][j] - '0' + heights[i - 1][j];
                    }
                }
            }
        }

        //遍历每层
        for (int i = heights.length - 1; i >= 0; i--) {
            int[] height = heights[i];
            for (int j = 0; j < height.length; j++) {
                if (height[j] > ans) {
                    getAns(height, j, 1, Integer.MAX_VALUE);
                }
            }
        }
        return ans * ans;
    }

    private void getAns(int[] height, int st, int size, int preH) {
        int h = Math.min(preH, height[st]);
        if (h >= size) {
            ans = Math.max(ans, size);
            if (st < height.length - 1) {
                getAns(height, st + 1, size + 1, h);
            }
        }
    }

}
