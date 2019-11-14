package code.code150.question119;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class Solution {
    /**
     * dp[i] 表示第k行第i-1个数
     * 公式：dp[i]=dp[i-1]*(k-i)/(i+1)
     * 又因为数据是对称的，计算到中间后后面的直接赋值
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long cur = 1;
        int mid = rowIndex / 2;
        for (int i = 0; i < mid; i++) {
            cur = cur * (rowIndex - i) / (i + 1);
            ans.add((int) cur);
        }
        if (rowIndex % 2 == 0) {
            mid--;
        }
        for (int i = mid; i >=0 ; i--) {
            ans.add(ans.get(i));
        }
        return ans;
    }

    /**
     * 递归
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow_(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex >= 1) {
            ans.add(1);
        }
        while (rowIndex >= 2) {
            int size = ans.size();
            for (int i = 1; i < size; i++) {
                if (i == 1) {
                    ans.add(i, ans.get(i - 1) + ans.get(i));
                } else {
                    ans.set(i, ans.get(i) + ans.get(i + 1));
                }
            }
            rowIndex--;
        }
        return ans;
    }

}
