package code.code50.question037;

import java.util.*;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * char[][] board = new char[][]{
 * {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
 * {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
 * {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
 * {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
 * {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
 * {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
 * {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
 * {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
 * {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
 * };
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/26
 */
public class Solution {
    private int[][] rows = new int[9][10];
    private int[][] columns = new int[9][10];
    private int[][] boxes = new int[9][10];
    private char[][] board;
    private boolean isSolved = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = Character.getNumericValue(c);
                    putNumber(n, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    /**
     * 回溯
     *
     * @param row
     * @param col
     */
    private void backtrack(int row, int col) {

        char c = board[row][col];
        if (c == '.') {
            for (int n = 1; n < 10; n++) {
                if (couldPut(n, row, col)) {
                    putNumber(n, row, col);
                    moveToNext(row, col);
                    if (!isSolved) {
                        removeNumber(n, row, col);
                    }
                }
            }
        } else {
            //如果不为空向一个位置移动
            moveToNext(row, col);
        }

    }

    /**
     * 移除数字
     *
     * @param n
     * @param row
     * @param col
     */
    private void removeNumber(int n, int row, int col) {
        int boxIndex = (row / 3) * 3 + col / 3;
        rows[row][n]--;
        columns[col][n]--;
        boxes[boxIndex][n]--;
        board[row][col] = '.';
    }

    /**
     * 判断是否可以设置到数组中
     *
     * @param n
     * @param row
     * @param col
     * @return
     */
    private boolean couldPut(int n, int row, int col) {
        int boxIndex = (row / 3) * 3 + col / 3;
        return columns[col][n] + rows[row][n] + boxes[boxIndex][n] == 0;
    }

    /**
     * 移动到下一个位置
     *
     * @param row
     * @param col
     */
    private void moveToNext(int row, int col) {
        if (row == 8 && col == 8) {
            //已移动到最后的位置，说明得出唯一解
            isSolved = true;
        } else {
            if (col == 8) {
                //下一行
                backtrack(row + 1, 0);
            } else {
                //右移
                backtrack(row, col + 1);
            }
        }
    }


    /**
     * 填充一个数字
     *
     * @param n
     * @param row
     * @param col
     */
    private void putNumber(int n, int row, int col) {
        int boxIndex = (row / 3) * 3 + col / 3;
        rows[row][n]++;
        columns[col][n]++;
        boxes[boxIndex][n]++;
        board[row][col] = (char) (n + '0');
    }

    public void solveSudoku__(char[][] board) {
        invoke(board);
    }

    public boolean invoke(char[][] board) {
        Map[] colMap = new HashMap[9];
        Map[] rowMap = new HashMap[9];
        Map[] boardMap = new HashMap[9];
        List[][] emptyList = new ArrayList[9][9];
        //先遍历一次，把已占用的数字填充到3个列表中
        for (int i = 0; i < 9; i++) {
            colMap[i] = new HashMap();
            rowMap[i] = new HashMap();
            boardMap[i] = new HashMap();
        }
        for (int i = 0; i < 9; i++) {
            Map subColumnMap = colMap[i];
            for (int j = 0; j < 9; j++) {
                Map subRowMap = rowMap[j];
                int boardIndex = (i / 3) * 3 + j / 3;
                Map subBoardMap = boardMap[boardIndex];
                char item = board[i][j];
                if ('.' == item) {
                    continue;
                }

                if (subColumnMap.containsKey(item) || subRowMap.containsKey(item) || subBoardMap.containsKey(item)) {
                    return false;
                } else {
                    subColumnMap.put(item, null);
                    subRowMap.put(item, null);
                    subBoardMap.put(item, null);
                }

            }
        }
        char[] charArr = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < 9; i++) {
            Map subColumnMap = colMap[i];
            for (int j = 0; j < 9; j++) {
                Map subRowMap = rowMap[j];
                List<Character> characterList = emptyList[i][j];
                int boardIndex = (i / 3) * 3 + j / 3;
                Map subBoardMap = boardMap[boardIndex];
                char item = board[i][j];
                if ('.' == item) {
                    characterList = new ArrayList<>();
                    for (char aCharArr : charArr) {
                        if (!subColumnMap.containsKey(aCharArr) && !subRowMap.containsKey(aCharArr) && !subBoardMap.containsKey(aCharArr)) {
                            characterList.add(aCharArr);
                        }
                    }
                    if (characterList.size() == 1) {
                        board[i][j] = characterList.get(0);
                        if (!reMapping(board, i, j, colMap, rowMap, boardMap, emptyList)) {
                            return false;
                        }
                    } else if (characterList.size() == 0) {
                        return false;
                    } else {
                        emptyList[i][j] = characterList;
                    }
                }
            }
        }

        //print(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char item = board[i][j];
                if ('.' == item) {
                    List<Character> characterList = emptyList[i][j];
                    if (characterList == null) {
                        return false;
                    }
                    for (Character character : characterList) {
                        char[][] temp = copy(board, new char[9][9]);
                        temp[i][j] = character;
                        if (invoke(temp)) {
                            if (!haveEmpty(temp)) {
                                board = copy(temp, board);
                                print(temp);
                                return true;
                            }
                        }

                    }
                }
            }
        }
        return true;
    }

    private boolean haveEmpty(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char item = board[i][j];
                if ('.' == item) {
                    return true;
                }
            }
        }
        return false;
    }

    private void print(char[][] board) {
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("---------------------------");
    }

    private char[][] copy(char[][] source, char[][] target) {
        for (int i = 0; i < 9; i++) {
            System.arraycopy(source[i], 0, target[i], 0, 9);

        }
        return target;
    }

    private boolean reMapping(char[][] board, int i, int j, Map[] colMap, Map[] rowMap, Map[] boardMap, List[][] emptyList) {
        Map subColumnMap = colMap[i];
        Map subRowMap = rowMap[j];
        int boardIndex = (i / 3) * 3 + j / 3;
        Map subBoardMap = boardMap[boardIndex];

        subColumnMap.put(board[i][j], null);
        subRowMap.put(board[i][j], null);
        subBoardMap.put(board[i][j], null);

        for (int index = 0; index < 9; index++) {
            List<Character> characterList = emptyList[i][index];
            if (null != characterList) {
                characterList.remove((Character) board[i][j]);
                if (characterList.size() == 1) {
                    emptyList[i][index] = null;
                    char aCharArr = characterList.get(0);
                    if (colMap[i].containsKey(aCharArr) || rowMap[index].containsKey(aCharArr) || boardMap[(i / 3) * 3 + index / 3].containsKey(aCharArr)) {
                        return false;
                    }
                    board[i][index] = aCharArr;
                    return reMapping(board, i, index, colMap, rowMap, boardMap, emptyList);
                }
            }
            characterList = emptyList[index][j];
            if (null != characterList) {
                characterList.remove((Character) board[i][j]);
                if (characterList.size() == 1) {
                    emptyList[index][j] = null;
                    char aCharArr = characterList.get(0);
                    if (colMap[index].containsKey(aCharArr) || rowMap[j].containsKey(aCharArr) || boardMap[(index / 3) * 3 + j / 3].containsKey(aCharArr)) {
                        return false;
                    }
                    board[index][j] = aCharArr;
                    return reMapping(board, index, j, colMap, rowMap, boardMap, emptyList);
                }
            }
        }
        int colSt = i / 3 * 3;
        int rowSt = j / 3 * 3;
        for (int col = colSt; col <= colSt + 2; col++) {
            for (int row = rowSt; row < rowSt + 2; row++) {
                List<Character> characterList = emptyList[col][row];
                if (null != characterList) {
                    characterList.remove((Character) board[i][j]);
                    if (characterList.size() == 1) {
                        emptyList[col][row] = null;
                        char aCharArr = characterList.get(0);
                        if (colMap[col].containsKey(aCharArr) || rowMap[row].containsKey(aCharArr) || boardMap[(col / 3) * 3 + row / 3].containsKey(aCharArr)) {
                            return false;
                        }
                        board[col][row] = aCharArr;
                        return reMapping(board, col, row, colMap, rowMap, boardMap, emptyList);
                    }
                }
            }
        }
        return true;
    }
}
