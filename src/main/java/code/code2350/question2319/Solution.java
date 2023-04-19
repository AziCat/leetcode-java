package code.code2350.question2319;

/**
 * 如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
 *
 * 矩阵对角线上的所有元素都 不是 0
 * 矩阵中所有其他元素都是 0
 * 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-matrix-is-x-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yjh
 * @since 2023/1/31
 */
public class Solution {
    /**
     * n == grid.length == grid[i].length
     * 3 <= n <= 100
     * 0 <= grid[i][j] <= 10的5次方
     * @param grid
     * @return
     */
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int item = grid[i][j];
                if (i == j || j == -i + n - 1) {
                    if (item == 0) {
                        return false;
                    }
                }else {
                    if (item != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
