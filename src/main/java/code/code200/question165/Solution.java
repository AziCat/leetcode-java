package code.code200.question165;

/**
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * <p>
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 * <p>
 *  . 字符不代表小数点，而是用于分隔数字序列。
 * <p>
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * <p>
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/24
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int max = Math.max(v1.length, v2.length);
        for (int i = 0; i < max; i++) {
            int i1 = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
            int i2 = i >= v2.length ? 0 : Integer.parseInt(v2[i]);
            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
        }
        return 0;
    }
}
