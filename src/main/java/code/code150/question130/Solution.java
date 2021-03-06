package code.code150.question130;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 先从边界开始找O，然后把不能填充的O设置为-，最后再遍历矩阵
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < col; i++) {
            fill(board, 0, i);
            fill(board, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            fill(board, i, 0);
            fill(board, i, col - 1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void fill(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (board[i][j] == 'O') {
                board[i][j] = '-';
                fill(board, i + 1, j);
                fill(board, i - 1, j);
                fill(board, i, j + 1);
                fill(board, i, j - 1);
            }
        }
    }
}
