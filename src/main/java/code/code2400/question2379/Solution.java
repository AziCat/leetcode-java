package code.code2400.question2379;

/**
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 *
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 *
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 *
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yjh
 * @since 2023/3/9
 */
public class Solution {
    /**
     * n == blocks.length
     * 1 <= n <= 100
     * blocks[i] 要么是 'W' ，要么是 'B' 。
     * 1 <= k <= n
     * @param blocks
     * @param k
     * @return
     */
    public int minimumRecolors(String blocks, int k) {
        //使用滑动窗口
        int ans = 100;
        int countB = 0;
        int left=0;
        int right=0;
        while (right < blocks.length()) {
            if (blocks.charAt(right) == 'B') {
                countB++;
            }
            if (right - left == k) {
                if(blocks.charAt(left)=='B'){
                    countB--;
                }
                left++;
            }
            right++;
            ans = Math.min(ans, k - countB);
        }
        return ans;
    }
}
