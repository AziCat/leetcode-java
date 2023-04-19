package code.code2000.question1996;

import java.util.*;

/**
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
 * <p>
 * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
 * <p>
 * 返回 弱角色 的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2022/1/28
 */
public class Solution {
    /**
     * 按照攻击力降序排序，攻击力相同的按照防御力升序排序；
     * <p>
     * 维护前面已经遍历过的角色的防御力的最大值defense，如果当前角色的防御值小于defense，那么即为弱角色；
     * <p>
     * 不可能出现defense出现在攻击力相同的角色中，因为[攻击力相同的按照防御力升序排序]很好地限制了这种情况；
     *
     * @param properties
     * @return
     */
    public int numberOfWeakCharacters(int[][] properties) {

        Arrays.sort(properties, (v1, v2) -> v1[0] != v2[0] ? v2[0] - v1[0] : v1[1] - v2[1]);
        int defense = properties[0][1];
        int ans = 0;
        for (int i = 1; i < properties.length; i++) {
            if (properties[i][1] < defense) {
                ans++;
                continue;
            }
            defense = Math.max(defense, properties[i][1]);
        }
        return ans;


    }

}
