package code.code250.question240;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/17
 */
public class Solution {
    /**
     * 从左下角开始，大就向右，小就向上
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }

    /**
     * 二分法
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix.length - 1;
        if (n == -1) {
            return false;
        }
        int m = matrix[0].length - 1;
        if (m == -1) {
            return false;
        }
        return findRow(matrix, 0, 0, m, target) || findCol(matrix, 0, 0, n, target);
    }

    /**
     * 行二分
     *
     * @return
     */
    private boolean findRow(int[][] matrix, int row, int start, int end, int target) {
        if (start > end) {
            return false;
        } else {
            int mid = (start + end) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                return findRow(matrix, row, start, mid - 1, target);
            } else {
                //目标在中点右侧或下侧
                return findRow(matrix, row, mid + 1, end, target) || findCol(matrix, mid, row + 1, matrix.length - 1, target);
            }
        }
    }

    /**
     * 列二分
     */
    private boolean findCol(int[][] matrix, int col, int start, int end, int target) {
        if (start > end) {
            return false;
        } else {
            int mid = (start + end) / 2;
            if (matrix[mid][col] == target) {
                return true;
            } else if (matrix[mid][col] > target) {
                return findCol(matrix, col, start, mid - 1, target);
            } else {
                //目标在中点右侧或下侧
                return findRow(matrix, mid, col + 1, matrix[0].length - 1, target) || findCol(matrix, col, mid + 1, end, target);
            }
        }
    }
}
