package code.code500.question463;

/**
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * <p>
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/6/23
 */
public class Solution {
    /**
     * 从左到右，从上到下遍历
     * 规律：每块陆地挨着x块陆地，那整体周长添加(4-2x)
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ans += 4;
                    //上
                    if (i != 0 && grid[i - 1][j] == 1) {
                        ans -= 2;
                    }
                    //左
                    if (j != 0 && grid[i][j - 1] == 1) {
                        ans -= 2;
                    }
                }
            }
        }
        return ans;
    }

}
