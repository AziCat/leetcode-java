package code.code2950.question2923;

/**
 * 2923. 找到冠军 I
 *
 * @author yjh
 * @since 2024/4/12
 */
public class Solution {
    public int findChampion(int[][] grid) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < grid.length; i++) {
            int winCounter = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    winCounter++;
                }
            }
            if (winCounter > max) {
                max = winCounter;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
