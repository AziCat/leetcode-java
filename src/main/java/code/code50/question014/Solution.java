package code.code50.question014;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/12
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("flow".indexOf("flower"));
    }

    /**
     * 水平扫描，先把数组第一个字符串当成最长前缀prefix，然后去跟下一个字符串匹配，不断缩减prefix的最后一位直至匹配当前字符串的前缀
     * 以此前缀再去匹配下一个字符串
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 遍历前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix_(String[] strs) {
        int p = 0;
        boolean isOutBound = false;
        StringBuilder sb = new StringBuilder();
        while (!isOutBound) {
            try {
                Character c = getPointChar(strs, p);
                if (null != c) {
                    sb.append(c);
                    p++;
                } else {
                    return sb.toString();
                }
            } catch (IndexOutOfBoundsException e) {
                isOutBound = true;
            }

        }
        return sb.toString();
    }

    private Character getPointChar(String[] strs, int p) {
        for (int i = 0; i < strs.length; i++) {
            if (i == strs.length - 1) {
                break;
            }
            if (strs[i].charAt(p) != strs[i + 1].charAt(p)) {
                return null;
            }
        }
        return strs[0].charAt(p);
    }
}
