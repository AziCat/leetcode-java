package code.code500.question451;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @version 1.0
 * @since 2021/4/22 14:28
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> numMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer num = numMap.getOrDefault(c, 0);
            num++;
            numMap.put(c, num);
        }
        StringBuilder sb = new StringBuilder();
        numMap.keySet().stream().sorted((o1, o2) -> numMap.get(o2)-numMap.get(o1)).forEach(c -> {
            for (int i = 0; i < numMap.get(c); i++) {
                sb.append(c);
            }
        });
        return sb.toString();
    }
}
