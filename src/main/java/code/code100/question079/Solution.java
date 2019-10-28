package code.code100.question079;

class Solution {
    private char[][] board;
    private boolean flag = false;
    private int count = 0;
    private String word;

    /**
     * 回溯算法
     * 首先遍历网格找到头字母，找到后开始进入回溯方法
     * 回溯方法：
     * 判断能走的方向，向该方向走run，如果标记为true直接返回，否则退回back
     * run方法：
     * 判断当前位置单词是否匹配word，如果匹配，计数器++，移除board内容，当计数器等于word长度把标记设置为true， 继续调用回溯方法
     * back方法：
     * 计数器--,填充board内容
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (flag) {
                    return true;
                }
                if (board[i][j] == word.charAt(0)) {
                    run(i, j);
                    back(i, j, word.charAt(0));
                }
            }
        }
        return flag;
    }

    private void backtrack(int row, int col) {
        //判断向上走
        if (row != 0 && board[row - 1][col] != '0' && board[row - 1][col] == word.charAt(count)) {
            char c = board[row - 1][col];
            run(row - 1, col);
            if (flag) {
                return;
            }
            back(row - 1, col, c);
        }
        //判断向下走
        if (row != board.length - 1 && board[row + 1][col] != '0' && board[row + 1][col] == word.charAt(count)) {
            char c = board[row + 1][col];
            run(row + 1, col);
            if (flag) {
                return;
            }
            back(row + 1, col, c);
        }
        //判断左走
        if (col != 0 && board[row][col - 1] != '0' && board[row][col - 1] == word.charAt(count)) {
            char c = board[row][col - 1];
            run(row, col - 1);
            if (flag) {
                return;
            }
            back(row, col - 1, c);

        }
        //判断右走
        if (col != board[0].length - 1 && board[row][col + 1] != '0' && board[row][col + 1] == word.charAt(count)) {
            char c = board[row][col + 1];
            run(row, col + 1);
            if (flag) {
                return;
            }
            back(row, col + 1, c);
        }
    }

    private void back(int row, int col, char c) {
        count--;
        board[row][col] = c;
    }

    private void run(int row, int col) {
        count++;
        board[row][col] = '0';
        if (count == word.length()) {
            flag = true;
        } else {
            backtrack(row, col);
        }
    }
}