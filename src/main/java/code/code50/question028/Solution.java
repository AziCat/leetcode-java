package code.code50.question028;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/19
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("aaaa".indexOf("a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        int l = 0;
        int r = 0;
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        while (l < haystackArr.length) {
            if (haystackArr[l] == needleArr[r]) {
                if (r == needleArr.length - 1) {
                    return l - r;
                }
                r++;
            } else if (r != 0) {
                l -= r;
                r = 0;
            }
            l++;
        }
        return -1;
    }
}
