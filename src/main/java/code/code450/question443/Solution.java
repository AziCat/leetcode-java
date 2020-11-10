package code.code450.question443;

/**
 * 给定一组字符，使用原地算法将其压缩。
 * <p>
 * 压缩后的长度必须始终小于或等于原数组长度。
 * <p>
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * <p>
 * 在完成原地修改输入数组后，返回数组的新长度。
 * <p>
 *  
 * <p>
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-compression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/11/10
 */
public class Solution {
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        char pre = chars[0];
        int p = 1, inputP = 0, counter = 1;
        while (p <= chars.length) {
            if (p < chars.length && pre == chars[p]) {
                counter++;
            } else {
                chars[inputP] = pre;
                inputP++;
                if (counter > 1) {
                    while (counter >= 10) {
                        chars[inputP] = (char) ('0' + counter / 10);
                        counter %= 10;
                        inputP++;
                    }
                    chars[inputP] = (char) ('0' + counter);
                    inputP++;
                    counter = 1;
                }
                if (p < chars.length) {
                    pre = chars[p];
                }
            }
            p++;
        }
        return inputP;
    }
}
