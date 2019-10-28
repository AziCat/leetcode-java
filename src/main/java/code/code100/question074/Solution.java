package code.code100.question074;

import java.util.Arrays;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/21
 */
public class Solution {
    /**
     * 竖向二分法找到target所在数组matrix[i]，在数组matrix[i]中使用二分法查找target
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int i = searchCol(0, n, target, matrix);
        if (i == -1) {
            return false;
        } else {
            return Arrays.binarySearch(matrix[i], target) >= 0;
        }
    }

    private int searchCol(int s, int e, int target, int[][] matrix) {
        if (s + 1 == e) {
            return s;
        }
        int mid = (s + e) / 2;
        if (matrix[s][0] <= target && target < matrix[mid][0]) {
            return searchCol(s, mid, target, matrix);
        } else if (matrix[mid][0] <= target) {
            return searchCol(mid, e, target, matrix);
        } else {
            return -1;
        }
    }
}
