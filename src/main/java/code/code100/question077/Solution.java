package code.code100.question077;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/combinations
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/22
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    private int size;
    private int n;

    /**
     * 使用回溯递归
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.size = k;
        backtrack(1);
        return ans;
    }

    private void backtrack(int index) {
        for (int i = index; i <= n - size + 1 + temp.size(); i++) {
            put(i);
            temp.remove(temp.size() - 1);
        }
    }

    private void put(int i) {
        temp.add(i);
        if (temp.size() == size) {
            List<Integer> item = new ArrayList<>(temp);
            ans.add(item);
        } else {
            backtrack(i + 1);
        }
    }
}
