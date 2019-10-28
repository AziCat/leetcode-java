package code.code100.question054;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/10
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return ans;
        }
        int n = matrix[0].length;
        int i = 0, j = 0, right = n, down = m, left = -1, up = 0;
        while (ans.size() != m * n) {
            while (j < right && ans.size() != m * n) {
                ans.add(matrix[i][j]);
                j++;
                if (j == right) {
                    right--;
                    i++;
                }
            }
            j--;
            while (i < down && ans.size() != m * n) {
                ans.add(matrix[i][j]);
                i++;
                if (i == down) {
                    down--;
                    j--;
                }
            }
            i--;
            while (j > left && ans.size() != m * n) {
                ans.add(matrix[i][j]);
                j--;
                if (j == left) {
                    left++;
                    i--;
                }
            }
            j++;
            while (i > up && ans.size() != m * n) {
                ans.add(matrix[i][j]);
                i--;
                if (i == up) {
                    up++;
                    j++;
                }
            }
            i++;
        }
        return ans;
    }
}
