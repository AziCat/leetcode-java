package code.code250.question216;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/15
 */
public class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> temp = new ArrayList<>();
    private int counter;
    private int k;
    private final int[] sum = {9, 17, 24, 30, 35, 39, 42, 44, 45};

    /**
     * 回溯
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.counter = n;
        this.k = k;
        if (k > 0 && k < 10) {
            backtrack(1);
        }
        return ans;
    }

    private void add(int num) {
        temp.add(num);
        counter -= num;
        if (temp.size() == k) {
            if (counter == 0) {
                ans.add(new ArrayList<>(temp));
            }
        } else {
            backtrack(num + 1);
        }
    }

    private void remove() {
        counter += temp.get(temp.size() - 1);
        temp.remove(temp.size() - 1);
    }

    private void backtrack(int start) {
        for (int i = start; i <= 9; i++) {
            if (counter - i > sum[k - temp.size()-1]) {
                //跳过
                continue;
            }
            int avg = (counter) / (k - temp.size());
            if (i > avg) {
                //没有结果
                break;
            }
            add(i);
            remove();
        }
    }
}
