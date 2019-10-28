package code.code50.question011;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/12
 */
public class Solution {
    /**
     * 暴力法，遍历所有结果得出最优解
     *
     * @param height
     * @return
     */
    public int maxArea_(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int mov = i + 1;
            while (mov < height.length) {
                int area = Math.min(height[i], height[mov]) * (mov - i);
                maxArea = Math.max(maxArea, area);
                mov++;
            }
        }
        return maxArea;
    }

    /**
     * 双指针，把指针定在数组的头尾，然后指针向里面靠拢。
     * 靠拢时因为长度在缩小，所以面积想要变大必须要使宽变大，则指针要向值比较大的方向移动
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int sp = 0;
        int ep = height.length - 1;
        while (sp != ep) {
            maxArea = Math.max(maxArea, Math.min(height[sp], height[ep]) * (ep - sp ));
            if (height[sp] < height[ep]) {
                sp++;
            } else {
                ep--;
            }
        }
        return maxArea;
    }
}
