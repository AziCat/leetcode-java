package code.code200.question174;

import java.util.Arrays;

/**
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 *  
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/19
 */
public class Solution {
    /**
     * 逆序使用动态规则
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length, cols = dungeon[0].length;
        //保存需要的最少血量
        int[] hpMin = new int[cols + 1];
        Arrays.fill(hpMin, Integer.MAX_VALUE);
        //初始化末尾
        hpMin[cols - 1] = dungeon[rows - 1][cols - 1] > 0 ? 1 : 1 - dungeon[rows - 1][cols - 1];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 && j == cols - 1) {
                    continue;
                }
                int min = Math.min(hpMin[j + 1], hpMin[j]);
                if (dungeon[i][j] < 0) {
                    hpMin[j] = min - dungeon[i][j];
                } else {
                    hpMin[j] = dungeon[i][j] < min ? min - dungeon[i][j] : 1;
                }
            }
        }
        return hpMin[0];
    }
}
