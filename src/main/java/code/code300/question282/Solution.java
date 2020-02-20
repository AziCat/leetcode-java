package code.code300.question282;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"]
 * 示例 2:
 * <p>
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 * 示例 3:
 * <p>
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 * 示例 4:
 * <p>
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 * 示例 5:
 * <p>
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expression-add-operators
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/19
 */
public class Solution {
    char[] num;
    char[] exp;
    int target;
    List<String> res;

    public List<String> addOperators(String num, int target) {
        this.res = new ArrayList<>();
        this.num = num.toCharArray();
        this.target = target;
        this.exp = new char[num.length() * 2];
        dfs(0, 0, 0, 0);
        return res;
    }

    private void dfs(int pos, int len, long prev, long curr) {
        if (pos == num.length) {
            if (curr == target) {
                res.add(new String(exp, 0, len));
            }
            return;
        }
        /**
         * s 记录该次 dfs的起始位置
         * pos是num的位置
         */
        int s = pos;
        /**
         * len是 放数字 的位置
         * l是 放运算符 的位置
         */
        int l = len;
        if (s != 0) {
            len++;
        }
        long n = 0;
        while (pos < num.length) {
            if (num[s] == '0' && pos - s > 0) {
                break;
            }
            n = n * 10 + num[pos] - '0';
            if (n > Integer.MAX_VALUE) {
                break;
            }
            exp[len++] = num[pos++];
            if (s == 0) {
                dfs(pos, len, n, n);
                continue;
            }
            exp[l] = '+';
            dfs(pos, len, n, curr + n);
            exp[l] = '-';
            dfs(pos, len, -n, curr - n);
            exp[l] = '*';
            dfs(pos, len, prev * n, curr - prev + prev * n);
        }
    }


}
