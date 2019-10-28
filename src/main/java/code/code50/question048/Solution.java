package code.code50.question048;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/rotate-image
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/9
 */
public class Solution {
    private int[][] matrix;
    private boolean[][] isSwap;

    /**
     * 找出变换后规律
     * Xa = n-1-Yb
     * Ya = Xb
     * <p>
     * a为after移动后
     * b为before移动前
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        this.matrix = matrix;
        this.isSwap = new boolean[matrix.length][matrix.length];
        int n = matrix.length - 1;
        if (n > 0) {
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix.length; y++) {
                    swap(n, x, y, null);
                }
            }
        }
    }

    private void swap(int n, int x, int y, Integer temp) {
        if (isSwap[y][x]) {
            return;
        }
        int num = matrix[y][x];
        if (null != temp) {
            matrix[y][x] = temp;
            isSwap[y][x] = true;
        }
        swap(n, n - y, x, num);
    }
}
