package code.code1350.question1329;

/**
 * @author yjh
 * @since 2024/4/29
 */
public class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for (int cur = mat.length - 1; cur >= 0; cur--) {
            int i = cur;
            int j = 0;
            while (i < mat.length && j < mat[0].length) {
                compareAndSwap(mat, i, j);
                i += 1;
                j += 1;
            }
        }

        for (int cur = 1; cur < mat[0].length; cur++) {
            int i = 0;
            int j = cur;
            while (i < mat.length && j < mat[0].length) {
                compareAndSwap(mat, i, j);
                i += 1;
                j += 1;
            }
        }
        return mat;
    }

    private void compareAndSwap(int[][] mat, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        int pre = mat[i - 1][j - 1];
        if (pre <= mat[i][j]) {
            return;
        }
        int temp = mat[i][j];
        mat[i][j] = pre;
        mat[i - 1][j - 1] = temp;
        compareAndSwap(mat, i - 1, j - 1);
    }
}
