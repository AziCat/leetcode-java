package code.code2350.question2315;

/**
 * 给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
 * <p>
 * 请你返回 不在 竖线对之间，s 中 '*' 的数目。
 * <p>
 * 注意，每个竖线 '|' 都会 恰好 属于一个对。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-asterisks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/1/30
 */
public class Solution {
    /**
     * 1 <= s.length <= 1000
     * s 只包含小写英文字母，竖线 '|' 和星号 '*' 。
     * s 包含 偶数 个竖线 '|' 。
     *
     * @param s
     * @return
     */
    public int countAsterisks(String s) {
        boolean flag = false;
        char[] chars = s.toCharArray();
        int ans = 0;

        for (char c : chars) {
            if (flag) {
                if( '|' == c){
                    flag = false;
                }
            } else {
                if ('|' == c) {
                    flag = true;
                } else if ('*' == c) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
