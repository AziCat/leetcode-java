package code.code2400.question2363;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质：
 * <p>
 * items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，weighti 表示第 i 件物品的 重量 。
 * items 中每件物品的价值都是 唯一的 。
 * 请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]， weighti 是所有价值为 valuei 物品的 重量之和 。
 * <p>
 * 注意：ret 应该按价值 升序 排序后返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-similar-items
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/2/28
 */
public class Solution {
    /**
     * 1 <= items1.length, items2.length <= 1000
     * items1[i].length == items2[i].length == 2
     * 1 <= valuei, weighti <= 1000
     * items1 中每个 valuei 都是 唯一的 。
     * items2 中每个 valuei 都是 唯一的 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/merge-similar-items
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param items1
     * @param items2
     * @return
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] map = new int[1001];
        for (int[] ints : items1) {
            map[ints[0]] += ints[1];
        }
        for (int[] ints : items2) {
            map[ints[0]] += ints[1];
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                ans.add(Arrays.asList(i, map[i]));
            }
        }
        return ans;
    }
}
