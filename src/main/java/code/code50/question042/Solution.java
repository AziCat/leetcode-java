package code.code50.question042;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/29
 */
public class Solution {
    private int ans = 0;
    private int[] height;

    public int trap(int[] height) {
        this.height = height;
        int left = 0, right = height.length - 1;
        while (left < right) {
            while (height[left] == 0) {
                left++;
            }
            while (height[right] == 0) {
                right--;
            }
            if (left < right) {
                int higherIndex = getHigher(left, right);
                if (higherIndex != -1) {
                    right = higherIndex;
                } else {
                    getArea(left, right);
                    left = right;
                    right = height.length - 1;
                }
            }
        }
        return ans;
    }

    private void getArea(int left, int right) {
        int min = Math.min(height[left], height[right]);
        ans += (right - left - 1) * min;
        for (int i = left + 1; i < right; i++) {
            ans -= Math.min(min, height[i]);
        }
    }

    private int getHigher(int left, int right) {
        int max = Math.min(height[left], height[right]);
        int maxIndex = -1;
        for (int i = left + 1; i < right ; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
