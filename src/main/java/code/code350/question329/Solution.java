package code.code350.question329;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/3/31
 */
public class Solution {
    private int[][] length;

    /**
     * 使用dfs+记忆
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int ans = 0;
        this.length = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (length[i][j] == 0) {
                    dfs(matrix, i, j);
                }
                ans = Math.max(ans, length[i][j]);
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, int row, int col) {
        int nearLen = 0;
        //判断能否上走
        if (row > 0 && matrix[row - 1][col] > matrix[row][col]) {
            if (length[row - 1][col] == 0) {
                dfs(matrix, row - 1, col);
            }
            nearLen = Math.max(nearLen, length[row - 1][col]);
        }
        //判断能否下走
        if (row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col]) {
            if (length[row + 1][col] == 0) {
                dfs(matrix, row + 1, col);
            }
            nearLen = Math.max(nearLen, length[row + 1][col]);
        }
        //判断能否左走
        if (col > 0 && matrix[row][col - 1] > matrix[row][col]) {
            if (length[row][col - 1] == 0) {
                dfs(matrix, row, col - 1);
            }
            nearLen = Math.max(nearLen, length[row][col - 1]);
        }
        //判断能否右走
        if (col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col]) {
            if (length[row][col + 1] == 0) {
                dfs(matrix, row, col + 1);
            }
            nearLen = Math.max(nearLen, length[row][col + 1]);
        }
        length[row][col] = 1 + nearLen;
    }
}
