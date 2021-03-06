package code.code400.question386;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * <p>
 * 例如，
 * <p>
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/13
 */
public class Solution {
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        dfs(0, n);
        return ans;
    }

    private void dfs(int seed, int n) {
        int counter = 10;
        while (seed <= n && counter > 0) {
            if (seed != 0) {
                ans.add(seed);
                dfs(seed * 10, n);
            }
            seed += 1;
            counter--;
        }
    }
}
