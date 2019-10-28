package code.code100.question052;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 返回 n皇后有多少个解，可以重用question050的代码
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/10
 */
public class Solution {
    private int[] rowBox;//记录横向已占用位置
    private int[] colBox;//记录竖向已占用位置
    private int[] xBox1;//记录正斜向已占用位置
    private int[] xBox2;//记录反斜向已占用位置
    private int ans = 0;

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        this.rowBox = new int[n];
        this.colBox = new int[n];
        this.xBox1 = new int[2 * n - 1];
        this.xBox2 = new int[2 * n - 1];
        backtrack(0, n);
        return ans;
    }

    private void backtrack(int row, int n) {
        for (int j = 0; j < n; j++) {
            if (rowBox[row] == 0 && colBox[j] == 0 && xBox1[row + j] == 0 && xBox2[row - j - 1 + n] == 0) {
                putQueen(row, j, n);
                removeQueen(row, j, n);
            }
        }
    }

    private void removeQueen(int row, int col, int n) {
        rowBox[row] = 0;
        colBox[col] = 0;
        xBox1[row + col] = 0;
        xBox2[row - col - 1 + n] = 0;
    }

    private void putQueen(int row, int col, int n) {
        rowBox[row] = -1;
        colBox[col] = -1;
        xBox1[row + col] = -1;
        xBox2[row - col - 1 + n] = -1;
        if (row == n - 1) {
            ans++;
        } else {
            backtrack(row + 1, n);
        }
    }
}
