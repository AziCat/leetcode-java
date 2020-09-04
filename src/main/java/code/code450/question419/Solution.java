package code.code450.question419;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/4
 */
public class Solution {
    /**
     * 假设所有战舰都是头向上，遍历时只统计头部数量
     * 时间复杂度O(n+m)空间复杂度O(1)
     *
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                //如果是X，判断当前位置左侧和上侧是否是.
                if (board[row][col] == 'X') {
                    if ((row == 0 || board[row - 1][col] == '.')
                            && (col == 0 || board[row][col - 1] == '.')) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
