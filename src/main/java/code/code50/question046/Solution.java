package code.code50.question046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/permutations
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/8
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    private int[] box;
    private int[] nums;

    /**
     * 递归回溯
     * <p>
     * 2 ms	37.2 MB
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.box = new int[nums.length];
        backtrack();
        return ans;
    }

    private void backtrack() {
        for (int i = 0; i < nums.length; i++) {
            if (box[i] == 0) {
                addNumber(i);
                removeNumber(i);
            }
        }
    }

    private void removeNumber(int i) {
        box[i] = 0;
        list.remove(new Integer(nums[i]));
    }

    private void addNumber(int i) {
        box[i] = -1;
        list.add(nums[i]);
        if (list.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
        } else {
            backtrack();
        }
    }

    /**
     * 蠢方法
     * 22 ms	37.6 MB
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        permute(ans, list);
        return ans;
    }

    private List<List<Integer>> permute(List<List<Integer>> ans, List<Integer> list) {
        if (list.size() == 1) {
            ans.add(list);
        } else {
            for (int i = 0; i < list.size(); i++) {
                List<Integer> temp = new ArrayList<>();
                copy(temp, i, list);
                ans = permute(ans, temp);

                for (List<Integer> an : ans) {
                    if (an.size() < list.size()) {
                        an.add(list.get(i));
                    }
                }
            }
        }
        return ans;
    }

    private void copy(List<Integer> temp, int i, List<Integer> list) {
        for (int i1 = 0; i1 < list.size(); i1++) {
            if (i1 == i) {
                continue;
            }
            temp.add(list.get(i1));
        }
    }
}
