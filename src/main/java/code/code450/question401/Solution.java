package code.code450.question401;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * <p>
 * 小时不会以零开头：
 * <p>
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * <p>
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/6/21
 */
public class Solution {
    private final List<String> ans = new ArrayList<>();
    /**
     * 0~5存放分钟，6~9存放小时
     */
    private final int[] light = {1, 2, 4, 8, 16, 32, 1, 2, 4, 8};

    private int turnedOn;

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn > 8) {
            return ans;
        }
        this.turnedOn = turnedOn;
        dfs(0, 0, 0, 0);
        return ans;
    }

    /**
     * 递归回溯
     *
     * @param hour
     * @param min
     * @param hasOn
     * @param beginIndex
     */
    private void dfs(int hour, int min, int hasOn, int beginIndex) {
        if (hour > 11 || min > 59) {
            return;
        }
        if (hasOn == turnedOn) {
            //添加到结果集中
            ans.add(hour + ":" + (min < 10 ? "0" : "") + min);
            return;
        }
        for (int i = beginIndex; i < light.length; i++) {
            if (i < 6) {
                //分钟
                dfs(hour, min + light[i], hasOn + 1, i + 1);
            } else {
                //小时
                dfs(hour + light[i], min, hasOn + 1, i + 1);
            }
        }
    }
}
