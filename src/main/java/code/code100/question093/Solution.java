package code.code100.question093;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 */
public class Solution {
    private List<String> ans = new ArrayList<>();
    /**
     * 记录"."的位置
     */
    private List<Integer> position = new ArrayList<>();


    /**
     * 回溯算法
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        if (s.length() >= 4) {
            position.add(0);
            backtrack(1, s);
        }
        return ans;
    }

    private void backtrack(int start, String s) {
        for (int i = start; i < start + 3 && i <= s.length(); i++) {
            if (canAdd(i, s)) {
                //添加"."
                addSignal(i, s);
                //移除"."
                position.remove(position.size() - 1);
            }
        }
    }

    /**
     * 判断当前能不能添加"."
     *
     * @param i
     * @param s
     * @return
     */
    private boolean canAdd(int i, String s) {
        //剩余长度是否合法
        if (s.length() - i > (4 - position.size()) * 3 || s.length() - i < 4 - position.size()) {
            return false;
        }
        //区间内网段是否合法
        int lastPosition = position.get(position.size() - 1);
        int length = i - lastPosition;
        if (length == 1) {
            //一位返回true
            return true;
        } else if (length == 2) {
            //不是0开头返回true
            return s.charAt(lastPosition) != '0';
        } else {
            //判断是否0开头
            //判断是否大于255
            return s.charAt(lastPosition) != '0' && Integer.parseInt(s.substring(lastPosition, i)) <= 255;
        }
    }

    /**
     * 添加符号"."
     *
     * @param i
     * @param s
     */
    private void addSignal(int i, String s) {
        position.add(i);
        if (position.size() == 5) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb.append(s.substring(position.get(j), position.get(j + 1))).append(".");
            }
            sb.append(s.substring(position.get(3), position.get(4)));
            ans.add(sb.toString());
        } else {
            backtrack(i + 1, s);
        }
    }
}
